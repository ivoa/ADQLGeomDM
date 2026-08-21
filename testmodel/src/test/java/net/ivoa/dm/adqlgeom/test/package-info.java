

/**
* package adqltest.
*   temporary model to explore the use of the ADQL Types.
*/

@ConverterRegistrations({
      @ConverterRegistration(converter = PointConverter.class, autoApply = true)
})
package net.ivoa.dm.adqlgeom.test;
import org.hibernate.annotations.ConverterRegistration;
import org.hibernate.annotations.ConverterRegistrations;
      