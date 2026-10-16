import org.gradle.internal.configuration.problems.firstTypeFrom

plugins {
    // this plugin provides all the vo-dml functionality
    id("net.ivoa.vo-dml.vodmltools") version "0.7.2"
    `maven-publish`
    signing
}
group = "net.ivoa.dm.testing"
version = "0.1-SNAPSHOT"

vodml {
    vodmlDir.set(file("vo-dml"))
    vodslDir.set(file("model"))
    bindingFiles.setFrom(file("vo-dml/ADQLTest.vodml-binding.xml"))

}


tasks.test {
    useJUnitPlatform()

}

dependencies {
    //all data models will want to depend on the base model at least
    implementation("net.ivoa.vo-dml:ivoa-base:1.0-SNAPSHOT") //use API if model exposes any of these base types in API
    implementation(project(":ADQLGeomDM"))
    // the dependencies below are related to testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.1.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    implementation("org.slf4j:slf4j-api:1.7.32")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.5.13")

    testImplementation("org.javastro:jaxbjpa-utils:0.2.3")
    testImplementation("org.javastro:jaxbjpa-utils:0.2.3:test")
    testImplementation("org.geolatte:geolatte-geom:1.9.0")
    testImplementation("org.hibernate.orm:hibernate-spatial:6.5.3.Final")
    testImplementation("org.orbisgis:h2gis:2.2.5")
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.jar {
    from(sourceSets.test.get().output)
}
tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.INCLUDE } //IMPL bugfix - see https://stackoverflow.com/questions/67265308/gradle-entry-classpath-is-a-duplicate-but-no-duplicate-handling-strategy-has-b


publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {

                name.set("ADQL Geometry types data model")
                description.set("A model for organising execution in a distributed system")
                url.set("https://github.com/ivoa/ADQLGeomDM")
                licenses {
                    license {
                        name.set("GNU General Public License v3.0")
                        url.set("https://www.gnu.org/licenses/gpl-3.0.html")
                    }
                }
                developers {
                    developer {
                        id.set("pahjbo")
                        name.set("Paul Harrison")
                        email.set("paul.harrison@manchester.ac.uk")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/ivoa/ADQLGeomDM.git")
                    developerConnection.set("scm:git:ssh://github.com/ivoa/ADQLGeomDM.git")
                    url.set("https://github.com/ivoa/ADQLGeomDM")
                }
            }
        }
    }
    repositories {
        // TODO really want to publish to a repo run by the IVOA
        maven {
            name = "uksrcrepo"
            credentials {
                username = (findProperty("uksrcNexusUsername") ?: System.getenv("UKSRC_REPO_USERNAME")) as String?
                password = (findProperty("uksrcNexusPassword") ?: System.getenv("UKSRC_REPO_PASSWORD")) as String?
            }
            val releasesRepoUrl = uri("https://repo.dev.uksrc.org/repository/maven-releases/")
            val snapshotsRepoUrl = uri("https://repo.dev.uksrc.org/repository/maven-snapshots/")
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

        }

    }
}

extra["isReleaseVersion"] = !version.toString().endsWith("SNAPSHOT")

signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])

}

tasks.withType<Sign>().configureEach {
    onlyIf("isReleaseVersion is set") { project.extra["isReleaseVersion"] as Boolean }
}
