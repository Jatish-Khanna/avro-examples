package com.example.avro.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;



public class AVROEmployeeSerializer extends AVROEmployeeServiceBase {
	public void serialize() throws Exception {
		GenericRecord firstEmployee = new GenericData.Record(schema);
		GenericRecord firstAddress = new GenericData.Record(schema.getField("address").schema());

		String[] name = { "Jatish", "Khanna" };
		firstEmployee.put("name", Arrays.asList(name));
		firstEmployee.put("employeeCertifications", new HashMap<>());
		firstEmployee.put("id", 1001);
		firstEmployee.put("intField", 0);
		firstEmployee.put("longField", 0l);

		firstAddress.put("flatNo", 11);
		firstAddress.put("pincode", 126101l);

		firstEmployee.put("address", firstAddress);

		DatumWriter<GenericRecord> writer = new SpecificDatumWriter<>(schema);

		DataFileWriter<GenericRecord> fileWriter = new DataFileWriter<>(writer);

		fileWriter.create(schema, new File("employee.avro"));
		fileWriter.append(firstEmployee);
		fileWriter.close();
	}
}
