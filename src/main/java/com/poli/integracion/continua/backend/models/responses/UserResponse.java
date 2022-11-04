package com.poli.integracion.continua.backend.models.responses;

import lombok.Data;

@Data
public class UserResponse {
  private Long id;
  private String name;
  private String email;
}
