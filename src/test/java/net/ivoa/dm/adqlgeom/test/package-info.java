

/**
* package adqltest.
*   temporary model to explore the use of the ADQL Types.
*/
@jakarta.xml.bind.annotation.XmlSchema(namespace = "http://ivoa.net/dm/adql/test/v0.1",elementFormDefault=XmlNsForm.UNQUALIFIED,
          attributeFormDefault=XmlNsForm.UNQUALIFIED, xmlns = {
@jakarta.xml.bind.annotation.XmlNs(namespaceURI = "http://ivoa.net/dm/adql/test/v0.1", prefix = "adqlt")
  })
@ConverterRegistrations({
      @ConverterRegistration(converter = PointConverter.class, autoApply = true)
})
package net.ivoa.dm.adqlgeom.test;
import jakarta.xml.bind.annotation.XmlNsForm;
import org.hibernate.annotations.ConverterRegistration;
import org.hibernate.annotations.ConverterRegistrations;
      