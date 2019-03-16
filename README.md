# avro-basic
The project to test the Avro features for converting JSON schema to Entity classes that are serializable and deserializable

** Serilization practise

  * Serialize an Object with Simple schema types
  * Serialize an Object with Collections as type
  * Serialize an Object with nested/complex type

** DeSerialize all the resources

** Java class generation before compilation during generate-sources phases using avro-maven-plugin

** Using 
 // Loading schema from file -
  Schmea, 
  
  // Instantiate Object -
  GenericData, 
  GenericData.Record, 
  Schema.getField sub-subschema, 
  
  // Serialization -
  DatumWriter, 
  DataFileWriter
  
  // Deserialization -
  DatumReader
  DataFileReader

mvn clean package
