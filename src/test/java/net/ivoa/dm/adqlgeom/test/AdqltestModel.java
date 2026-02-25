
    package net.ivoa.dm.adqlgeom.test;
    import java.io.IOException;
    import java.util.List;
    import java.util.Set;
    import java.util.Map;
    import java.util.Collection;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.stream.Collectors;
    import java.util.stream.Stream;
    import java.util.AbstractMap;

    import jakarta.xml.bind.JAXBContext;
    import jakarta.xml.bind.annotation.XmlElement;
    import jakarta.xml.bind.annotation.XmlElements;
    import jakarta.xml.bind.annotation.XmlRootElement;
    import jakarta.xml.bind.annotation.XmlType;
    import jakarta.xml.bind.annotation.XmlAccessType;
    import jakarta.xml.bind.annotation.XmlAccessorType;
    import jakarta.xml.bind.JAXBException;

    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import com.fasterxml.jackson.annotation.JsonTypeInfo;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
    import com.fasterxml.jackson.annotation.JsonProperty;

    import org.ivoa.vodml.jaxb.XmlIdManagement;
    import org.ivoa.vodml.ModelManagement;
    import org.ivoa.vodml.VodmlModel;
    import org.ivoa.vodml.ModelDescription;
    import org.ivoa.vodml.annotation.VoDml;
    import org.ivoa.vodml.annotation.VodmlRole;
    import org.ivoa.vodml.ModelContext;
    import org.ivoa.vodml.nav.ReferenceCache;
    import org.ivoa.vodml.vocabularies.Vocabulary;

        /** The container class for the adqltest Model.
        * temporary model to explore the use of the ADQL Types
        */
    @XmlAccessorType(XmlAccessType.NONE)
    @XmlRootElement(name="adqltestModel")
    @XmlType(propOrder = {"refs","content"} )
    @JsonTypeInfo(include=JsonTypeInfo.As.WRAPPER_OBJECT, use=JsonTypeInfo.Id.NAME)
    @JsonIgnoreProperties({"refmap"})
    @VoDml(id="adqltest" ,role = VodmlRole.model, type="adqltest")
        public class AdqltestModel implements VodmlModel<AdqltestModel> {

    /** A container class for the references in the model. */
    @XmlType
    public static class References {
    
    }
    private References refs = new References();

        /**
        * @return the refs
        */
        private References getRefs() {
        return refs;
        }


        /**
        * @param refs the refs to set
        */
        @XmlElement(required = false)
        private void setRefs(References refs) {
        this.refs = refs;
        
        }


    @SuppressWarnings("rawtypes")
    private static java.util.List<Class> refOrder = java.util.List.of();
    
    @XmlElements(value = {
      
        @XmlElement(name="aTest",
               type = net.ivoa.dm.adqlgeom.test.ATest.class)
                    
    })
        
  @com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver(value = org.ivoa.vodml.json.VodmlTypeResolver.class)
   //   @com.fasterxml.jackson.annotation.JsonTypeInfo (use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT )
  @com.fasterxml.jackson.annotation.JsonTypeInfo (use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY,property = "@type" )
  
    private List<Object> content  = new ArrayList<>();

    /** default constructor.
    */
    public AdqltestModel(){
        
                //no references
            
    }

    private static volatile Map<String,Vocabulary> vocabs;

        private static void loadVocabs() {
        vocabs = new HashMap<>();
        

        }
        
        
        /**
        * Test if a term is in the vocabulary.
        * @param value the value to test
        * @param vocabulary the uri for the vocabulary.
        * @return true if the term is in the vocabulary.
        */
        public static boolean isInVocabulary(String value, String vocabulary)
        {
        if(vocabs == null)
        {
          synchronized(AdqltestModel.class) {
        loadVocabs();
        }
        }
        if(value == null) return true;
        if(vocabs.containsKey(vocabulary))
        {
        return vocabs.get(vocabulary).hasTerm(value);
        }
        return false;
        }


        

      /**
      * add ATest to model.
      * @param c  net.ivoa.dm.adqlgeom.test.ATest
          */
          public void addContent( final net.ivoa.dm.adqlgeom.test.ATest c)
      {
      content.add(c);
      
      }
          /**
          * remove ATest from model.
          *  @param c  net.ivoa.dm.adqlgeom.test.ATest
          */
      public void deleteContent( final net.ivoa.dm.adqlgeom.test.ATest c)
      {
      content.remove(c);
      
      }

      
        /**
        * Get the content of the given type.
        * @param <T> The type of the content
        * @param c the class of the content.
        * @return the content.
        */
        @SuppressWarnings("unchecked")
      public <T> List<T> getContent(Class<T> c) {
        if(!Stream.concat(refOrder.stream(), modelDescription.contentClasses().stream()).anyMatch(i -> i.isAssignableFrom(c))) throw new IllegalArgumentException(c.getCanonicalName() + " is not part of the model");

        return (List<T>)
        
                content.stream()
            
        .filter(p -> p.getClass().isAssignableFrom(c)).collect(
      Collectors.toUnmodifiableList()
      );

      }
      @Override
      public void processReferences()
      {
        List<XmlIdManagement> il = org.ivoa.vodml.nav.Util.findXmlIDs(content);
        
        org.ivoa.vodml.nav.Util.makeUniqueIDs(il);
      }


      /** if the model has references.
        * @return true if the model has references.
        */
      public static boolean hasReferences(){
         return false;
      }

        /**
        * the context factory for the model.
        * @return the JAXBContext.
        * @throws JAXBException if there is a problem.
        */
        public static JAXBContext contextFactory()  throws JAXBException
      {
      
         return JAXBContext.newInstance("org.ivoa.dm.adqlgeom:net.ivoa.dm.adqlgeom.test:org.ivoa.dm.ivoa" );
      }
        /** The persistence unit name for the model.
        * @return the name.
        */
       public static String pu_name(){
        return "adqltest";
        }

        /**
        * Return a Jackson objectMapper suitable for JSON serialzation.
        * @return the objectmapper.
        */
        public static ObjectMapper jsonMapper()
        {
        return org.ivoa.vodml.json.JsonManagement.jsonMapper(AdqltestModel.modelDescription);
        }
        /**
        * generate management interface instance for model.
        * @return the management interface.
        */
        @Override
        public ModelManagement<AdqltestModel> management() {return new ModelManagement<AdqltestModel>()
        {
        /**
        * {@inheritDoc}
        */
        @Override
        public String pu_name() {return AdqltestModel.pu_name();}
        /**
        * {@inheritDoc}
        */
        @Override
        public JAXBContext contextFactory() throws JAXBException {  return AdqltestModel.contextFactory();}

        /**
        * {@inheritDoc}
        */
        @Override
        public boolean hasReferences() { return AdqltestModel.hasReferences();}

        /**
        * {@inheritDoc}
        */
        @Override
        public void persistRefs(jakarta.persistence.EntityManager em)
        {
        
        }

        /**
        * {@inheritDoc}
        */
        @Override
        public ObjectMapper jsonMapper() { return AdqltestModel.jsonMapper();}

        /**
        * {@inheritDoc}
        */
        @Override
        public AdqltestModel theModel() { return AdqltestModel.this;}

        /**
        * {@inheritDoc}
        */
        @Override
        public List<Object> getContent() {
        return content;
        }

        /**
        * {@inheritDoc}
        */
        @Override
        public ModelDescription description() {
        return modelDescription;
        }

        };};

        /**
        * the description.
        */
        public static final ModelDescription modelDescription = new ModelDescription() {
        @SuppressWarnings("rawtypes")
        @Override
        public Map<String, Class> utypeToClassMap() {
        final HashMap<String, Class> retval = new HashMap<>();
        
        retval.put("adqlgeom:Point", org.javastro.ivoacore.pgsphere.types.Point.class);
        
        retval.put("adqlgeom:Line", org.ivoa.dm.adqlgeom.Line.class);
        
        retval.put("adqlgeom:Shape", org.ivoa.dm.adqlgeom.Shape.class);
        
        retval.put("adqlgeom:Circle", org.ivoa.dm.adqlgeom.Circle.class);
        
        retval.put("adqlgeom:Ellipse", org.ivoa.dm.adqlgeom.Ellipse.class);
        
        retval.put("adqlgeom:MultiShape", org.ivoa.dm.adqlgeom.MultiShape.class);
        
        retval.put("adqlgeom:Polygon", org.ivoa.dm.adqlgeom.Polygon.class);
        
        retval.put("adqlgeom:Box", org.ivoa.dm.adqlgeom.Box.class);
        
        retval.put("adqlgeom:Interval", org.ivoa.dm.adqlgeom.Interval.class);
        
        retval.put("adqltest:ATest", net.ivoa.dm.adqlgeom.test.ATest.class);
        
        retval.put("ivoa:IntegerQuantity", org.ivoa.dm.ivoa.IntegerQuantity.class);
        
        retval.put("ivoa:Quantity", org.ivoa.dm.ivoa.Quantity.class);
        
        retval.put("ivoa:RealQuantity", org.ivoa.dm.ivoa.RealQuantity.class);
        
        return retval;
        }

        @Override
        public Map<String, String> schemaMap() {
        final  Map<String,String> schemaMap = new HashMap<>();
        
            schemaMap.put("http://ivoa.net/dm/adqlgeom/v0.1","ADQLGeomDM-v1.vo-dml.xsd");
        
            schemaMap.put("http://ivoa.net/dm/adql/test/v0.1","ADQLTest.vo-dml.xsd");
        
            schemaMap.put("http://ivoa.net/vodml/ivoa","IVOA-v1.0.vo-dml.xsd");
        
        return schemaMap;
        }

        @Override
        public String xmlNamespace() {
        return "http://ivoa.net/dm/adql/test/v0.1";

        }

        @Override
        public String jsonSchema() {
        return "https://ivoa.net/dm/ADQLTest.vo-dml.json";
        }

        /**
        * Return a list of content classes for this model.
        * @return the list.
        */
        @Override
        @SuppressWarnings("rawtypes")
        public  java.util.List<Class> contentClasses()
        {
        return java.util.List.of(
        net.ivoa.dm.adqlgeom.test.ATest.class
        );
        }

        
        /**
        * Return a list of all classes for this model and included models.
        * Generally useful for things like JPA.
        * @return the list.
        */
        @Override
        public  java.util.List<String> allClassNames()
        {
        return java.util.List.of(
        "net.ivoa.dm.adqlgeom.test.ATest","net.ivoa.dm.adqlgeom.test.ATest","org.javastro.ivoacore.pgsphere.types.Point","org.ivoa.dm.adqlgeom.Line","org.ivoa.dm.adqlgeom.Shape","org.ivoa.dm.adqlgeom.Circle","org.ivoa.dm.adqlgeom.Ellipse","org.ivoa.dm.adqlgeom.MultiShape","org.ivoa.dm.adqlgeom.Polygon","org.ivoa.dm.adqlgeom.Box","org.ivoa.dm.adqlgeom.Interval","org.ivoa.vodml.stdtypes.Unit","org.ivoa.vodml.stdtypes.Complex","org.ivoa.vodml.stdtypes.Rational","org.ivoa.dm.ivoa.IntegerQuantity","org.ivoa.dm.ivoa.Quantity","org.ivoa.dm.ivoa.RealQuantity"
        );
        }

        };
        
        /** the TAP schema for the model. The schema is represented via the TAPSchemaDM datamodel.
        @return an InputStream to the XML representation of the model.
        */
        public static java.io.InputStream TAPSchema()
        {
        return AdqltestModel.class.getResourceAsStream("/ADQLTest.vo-dml.tap.xml");
        }

        /** create a context in preparation for cloning. */
        @SuppressWarnings("rawtypes")
        public void createContext()
        {

        final Map<Class, ReferenceCache> collect = Map.ofEntries(
        
        );
        ModelContext.create(  collect );
        }

        }
    