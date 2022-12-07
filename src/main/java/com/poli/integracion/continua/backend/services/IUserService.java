package com.poli.integracion.continua.backend.services;

import com.poli.integracion.continua.backend.entities.UserEntity;
import com.poli.integracion.continua.backend.models.requests.UserRegisterRequestModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
  UserDetails loadUserByUsername(String username);
  UserEntity createUser(UserRegisterRequestModel user);
}
