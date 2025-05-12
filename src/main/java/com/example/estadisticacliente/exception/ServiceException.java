package com.example.estadisticacliente.exception;

import org.springframework.http.HttpStatus;

/**
 * Base Service Exception
 */
public class ServiceException extends Exception {

   protected final HttpStatus exceptionCode;

   protected final String message;

   public ServiceException(HttpStatus exceptionCode, String message) {
      this.exceptionCode = exceptionCode;
      this.message = message;
   }


   @Override
   public String getMessage() {
      return this.message;
   }

   public HttpStatus getExceptionCode() {
      return exceptionCode;
   }
}
