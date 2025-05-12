package com.example.estadisticacliente.controller;

import com.example.estadisticacliente.exception.ExceptionResponse;
import com.example.estadisticacliente.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@ControllerAdvice
public class AdviceController {

   @ExceptionHandler(value = { ServiceException.class })
   public ResponseEntity<ExceptionResponse> handleException(ServiceException e) {
      return ResponseEntity
            .status(e.getExceptionCode().value())
            .body(new ExceptionResponse(e.getMessage(), e.getExceptionCode().value()));
   }

   @ExceptionHandler({ RuntimeException.class })
   public ResponseEntity<ExceptionResponse> handleException(RuntimeException e) {
      if (e instanceof MethodArgumentTypeMismatchException) {
         return ResponseEntity.status(PRECONDITION_FAILED)
                 .body(new ExceptionResponse("Parametro de distinto tipo", PRECONDITION_FAILED.value()));
      }
      if (e instanceof HttpMessageNotReadableException) {
         return ResponseEntity.status(PRECONDITION_FAILED)
                 .body(new ExceptionResponse("Json mal formateado", PRECONDITION_FAILED.value()));
      }
      return ResponseEntity.status(INTERNAL_SERVER_ERROR)
              .body(new ExceptionResponse("Error interno.", INTERNAL_SERVER_ERROR.value()));
   }

}
