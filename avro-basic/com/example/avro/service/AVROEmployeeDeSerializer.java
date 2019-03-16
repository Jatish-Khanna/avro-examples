package com.example.avro.service;

import java.io.File;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

public class AVROEmployeeDeSerializer {

	public void deserialize() throws Exception {
    Schema schema = new Schema.Parser().parse(new File("employee.avsc"));
		
	DatumReader<GenericRecord> reader = new SpecificDatumReader<>(schema);
	
	DataFileReader<GenericRecord> fileReader = new DataFileReader<>(new File("employee.avro"), reader);
	
	GenericRecord employee = null;
	
	while(fileReader.hasNext()) {
		employee = fileReader.next(employee);
		System.out.println("Employee Info: "+ employee);
	}
	
	fileReader.close();
  }
}
