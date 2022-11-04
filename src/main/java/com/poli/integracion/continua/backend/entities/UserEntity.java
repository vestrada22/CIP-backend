package com.poli.integracion.continua.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "users")
@Data
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;
}
