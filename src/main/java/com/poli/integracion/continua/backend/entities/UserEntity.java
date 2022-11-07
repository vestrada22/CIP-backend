package com.poli.integracion.continua.backend.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity(name = "users")
@Data
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  @Email
  private String email;

  @Column(nullable = false)
  private String password;
}
