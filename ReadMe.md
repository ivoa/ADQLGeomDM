ADQLGeomDM Project
===================

This project uses [VO-DML tools](https://ivoa.github.io/vo-dml/) to define a data model that represents the [Geometry Types in ADQL](https://www.ivoa.net/documents/ADQL/20231215/REC-ADQL-2.1.html#tth_sEc3.5) with some additional types from [PGSphere](https://postgrespro.github.io/pgsphere/index.html)

> [!Note]
> some of the model classes are not auto-generated, but come from [the javastro pgsphere library](https://github.com/Javastro/ivoacore/tree/main/pgsphere)


Further information in the [ADQLGeomDM documentation](https://ivoa.github.io/ADQLGeomDM/)

The source for the model is in [model/ADQLGeomDM-v1.vodsl](model/ADQLGeomDM-v1.vodsl)

[![Publish To Repository](https://github.com/ivoa/ADQLGeomDM/actions/workflows/publish.yml/badge.svg)](https://github.com/ivoa/ADQLGeomDM/actions/workflows/publish.yml)

<img alt="Maven metadata URL" src="https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo.dev.uksrc.org%2Frepository%2Fmaven-public%2Fnet%2Fivoa%2Fdm%2FADQLGeomDM%2Fmaven-metadata.xml&link=https%3A%2F%2Frepo.dev.uksrc.org%2F%23browse%2Fsearch%3Dattributes.maven2.artifactId%253DADQLGeomDM%2520AND%2520attributes.maven2.groupId%253Dnet.ivoa.dm%3ANX.coreui.model.Component-8&link=https%3A%2F%2Frepo.dev.uksrc.org%2Fservice%2Frest%2Frepository%2Fbrowse%2Fmaven-public%2Fnet%2Fivoa%2Fdm%2FADQLGeomDM%2F">



```
gradle test
```
should build the model and run tests against it.
```shell
gradle testSite
```
should build the site and make it available at http://localhost:8000

