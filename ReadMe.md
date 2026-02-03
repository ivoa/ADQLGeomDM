ADQLGeomDM Project
===================

This project uses [VO-DML tools](https://ivoa.github.io/vo-dml/) to define a data model that represents the [Geometry Types in ADQL](https://www.ivoa.net/documents/ADQL/20231215/REC-ADQL-2.1.html#tth_sEc3.5)

Further information in the [ADQLGeomDM documentation](https://ivoa.github.io/ADQLGeomDM/)

The source for the model is in [model/ADQLGeomDM-v1.vodsl](model/ADQLGeomDM-v1.vodsl)

```
gradle test
```
should build the model and run tests against it.
```shell
gradle testSite
```
should build the site and make it available at http://localhost:8000

