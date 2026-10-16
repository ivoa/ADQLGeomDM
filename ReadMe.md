ADQLGeomDM Project
===================

This project uses [VO-DML tools](https://ivoa.github.io/vo-dml/) to define a data model that represents the [Geometry Types in ADQL](https://www.ivoa.net/documents/ADQL/20231215/REC-ADQL-2.1.html#tth_sEc3.5) with some additional types from [PGSphere](https://postgrespro.github.io/pgsphere/index.html)

> [!Note]
> some of the model classes are not auto-generated, but come from [the javastro pgsphere library](https://github.com/Javastro/ivoacore/tree/main/pgsphere)


Further information in the [ADQLGeomDM documentation](https://ivoa.github.io/ADQLGeomDM/)

The source for the model is in [model/ADQLGeomDM-v1.vodsl](model/ADQLGeomDM-v1.vodsl)

[![Publish To Repository](https://github.com/ivoa/ADQLGeomDM/actions/workflows/publish.yml/badge.svg)](https://github.com/ivoa/ADQLGeomDM/actions/workflows/publish.yml) to the [UKSRC repository](https://repo.dev.uksrc.org/#browse/search/generic=attributes.maven2.groupId%3Dnet.ivoa.dm%20AND%20attributes.maven2.artifactId%3DADQLGeomDM)



To use the library in your project, add the following dependency to your build.gradle.kts file:

```kotlin
dependencies {
    implementation("net.ivoa.dm:ADQLGeomDM:0.9.0")
}
```

As the library uses pgsphere specific types, unit testing is more difficult - however by depending on 

```kotlin
dependencies {
    testImplementation("net.ivoa.dm.testing:ADQLGeomDMTesting:0.1-SNAPSHOT")
}
```
and then using the `net.ivoa.dm.adqlgeom.test.ADQLGeomDBRoundTripTest` as the base class for your tests, you can get a test h2db database with geometric types converted to the hibernate spatial equivalent.


```
gradle test
```
should build the model and run tests against it.
```shell
gradle testSite
```
should build the site and make it available at http://localhost:8000

