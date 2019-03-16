package com.example.avro.service;

import java.io.IOException;
import org.apache.avro.Schema;


public abstract class AVROEmployeeServiceBase {
  protected Schema schema;

  public AVROEmployeeServiceBase() {
    try {
      schema =
          new Schema.Parser().parse(this.getClass().getResourceAsStream("/input/employee.avsc"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
