plugins {
    // this plugin provides all the vo-dml functionality
    id("net.ivoa.vo-dml.vodmltools") version "0.7.0"

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
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    implementation("org.slf4j:slf4j-api:1.7.32")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.5.13")

    testImplementation("org.javastro:jaxbjpa-utils:0.2.3")
    testImplementation("org.javastro:jaxbjpa-utils:0.2.3:test")
    testImplementation("org.geolatte:geolatte-geom:1.9.0")
    implementation("org.hibernate.orm:hibernate-spatial:6.5.3.Final")
    testImplementation("org.orbisgis:h2gis:2.2.5")
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


