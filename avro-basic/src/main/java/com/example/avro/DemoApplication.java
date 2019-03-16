package com.example.avro;

import com.example.avro.service.AVROEmployeeDeSerializer;
import com.example.avro.service.AVROEmployeeSerializer;


class DemoApplication {


	public static void main(String[] args) throws Exception {
		//SpringApplication.run(DemoApplication.class, args);
		new AVROEmployeeSerializer().serialize();
		new AVROEmployeeDeSerializer().deserialize();
	}

}
