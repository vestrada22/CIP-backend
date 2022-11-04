package com.poli.integracion.continua.backend.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorsValidation {
  private Map<String, String> errors;
  private Date timestamp;
}
