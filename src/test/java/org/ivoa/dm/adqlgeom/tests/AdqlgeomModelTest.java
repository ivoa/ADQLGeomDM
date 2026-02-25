package org.ivoa.dm.adqlgeom.tests;
/*
 * Created on 10/05/2023 by Paul Harrison (paul.harrison@manchester.ac.uk).
 */

import net.ivoa.dm.adqlgeom.test.AdqltestModel;
import org.ivoa.dm.adqlgeom.Circle;
import org.ivoa.dm.adqlgeom.Interval;
import org.ivoa.dm.adqlgeom.Polygon;
import org.ivoa.vodml.testing.AutoDBRoundTripTest;
import net.ivoa.dm.adqlgeom.test.ATest;
import org.junit.jupiter.api.Assertions;
import org.javastro.ivoacore.pgsphere.types.Point;
import java.util.List;

/**
 * This will run a XML and JSON round trip test on the model inst
 */
public class AdqlgeomModelTest extends AutoDBRoundTripTest<AdqltestModel, Long, ATest> {

   private ATest atest;

   @Override
    public AdqltestModel createModel() {
        // create the model instance here.
       AdqltestModel retval = new AdqltestModel();

       atest = ATest.createATest(
             t -> {
                t.acircle = new Circle(new Point(1.1, 2.4), 4.0);
                t.aninterval = new Interval(4.5, 7.1);
                t.apoint = new Point(5.0, 6.0);
                t.apoly = new Polygon(List.of(new Point[]{new Point(5.0, 6.0), new Point(5.0, 6.5), new Point(6.0, 3.7),
                      new Point(4.0, 6.0), new Point(1.0, 2.0),}));
//               t.amultishape = new MultiShape(List.of(
//                     new Circle(new Point(1.1, 2.4), 4.0), new Circle(new Point(2.4, 4.4), 2.1)
//               ));
             }
       );
        retval.addContent(atest);
        return retval;
    }

    @Override
    public void testModel(AdqltestModel adqlgeomModel) {
       ATest atestread = adqlgeomModel.getContent(ATest.class).get(0);
       Assertions.assertTrue(atestread.getApoint().equals(atest.getApoint()));
       Assertions.assertTrue(atestread.getAcircle().equals(atest.getAcircle()));
       Assertions.assertTrue(atestread.getAninterval().equals(atest.getAninterval()));
       Assertions.assertTrue(atestread.getApoly().equals(atest.getApoly()));

    }

   @Override
   public ATest entityForDb() {
      return atest;
   }

   @Override
   public void testEntity(ATest e) {
      //TODO actually run some tests
   }
}
