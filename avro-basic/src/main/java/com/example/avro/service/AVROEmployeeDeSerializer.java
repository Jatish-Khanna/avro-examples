package com.example.avro.service;

import java.io.File;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

public class AVROEmployeeDeSerializer extends AVROEmployeeServiceBase {

 public void deserialize() throws Exception {
  DatumReader<GenericRecord> reader = new SpecificDatumReader<>(schema);

  DataFileReader<GenericRecord> fileReader = new DataFileReader<>(new File("employee.avro"), reader);

  GenericRecord employee = null;

  while (fileReader.hasNext()) {
   employee = fileReader.next(employee);
   System.out.println("Employee Info: " + employee);
  }

  fileReader.close();
 }
}
