package com.poli.integracion.continua.backend.services;

import com.poli.integracion.continua.backend.entities.UserEntity;
import com.poli.integracion.continua.backend.models.requests.UserRegisterRequestModel;

public interface IUserService {
  UserEntity createUser(UserRegisterRequestModel user);
}
