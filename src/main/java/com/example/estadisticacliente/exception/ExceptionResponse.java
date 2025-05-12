package com.example.estadisticacliente.exception;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {

   private String readableMsg;

   private int httpCode;

   public ExceptionResponse(String readableMsg, int httpCode) {
      this.readableMsg = readableMsg;
      this.httpCode = httpCode;
   }

   public String getReadableMsg() {
      return readableMsg;
   }

   public int getHttpCode() {
      return httpCode;
   }
}
