package net.ivoa.dm.adqlgeom.test;


import org.ivoa.vodml.VodmlModel;
import org.ivoa.vodml.jpa.JPAManipulationsForObjectType;
import org.ivoa.vodml.testing.AutoDBRoundTripTest;

import java.util.List;

public abstract class ADQLGeomDBRoundTripTest<M extends VodmlModel<M>, I, T extends JPAManipulationsForObjectType<I>> extends AutoDBRoundTripTest<M , I, T > {

    @Override
    protected List<String> additionalJPAClasses() {
        return List.of("net.ivoa.dm.adqlgeom.test.PointConverter", "net.ivoa.dm.adqlgeom.test.PolygonConverter");
    }
}


