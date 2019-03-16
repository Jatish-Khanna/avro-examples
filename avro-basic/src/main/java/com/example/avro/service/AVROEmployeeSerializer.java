package com.example.avro.service;

import java.io.File;

public class AVROEmployeeSerializer {
	
  public void serialize() throws Exception {
    Schema schema = new Schema.Parser().parse(new File("employee.avsc"));
	
	GenericRecord firstEmployee = new GenericData.Record(schema);
	
	firstEmployee.put("name","Jatish Khanna");
	firstEmployee.put("id", 1001);
	firstEmployee.put("company", "Infosys Ltd.");
	
	DatumWriter<GenericRecord> writer = new SpecificDatumWriter<>(schema);
	
	DataFileWriter<GenericRecord> fileWriter = new DataFileWriter<>(writer);
	
	fileWriter.create(schema, new File("employee.avro"));
	fileWriter.append(firstEmployee);
	fileWriter.close();
  }
}
