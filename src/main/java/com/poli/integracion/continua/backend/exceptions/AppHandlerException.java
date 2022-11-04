package com.poli.integracion.continua.backend.exceptions;

import com.poli.integracion.continua.backend.models.responses.ErrorsValidation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppHandlerException {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  ResponseEntity<Object> handleErrorValidationException(MethodArgumentNotValidException exception, WebRequest webRequest) {
    Map<String, String> errors = new HashMap<>();
    for (ObjectError error : exception.getBindingResult().getAllErrors()) {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    }

    ErrorsValidation errorsValidation = new ErrorsValidation(errors, new Date());
    return new ResponseEntity<>(errorsValidation, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
}
