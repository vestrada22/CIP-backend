package com.poli.integracion.continua.backend.services;

import com.poli.integracion.continua.backend.entities.UserEntity;
import com.poli.integracion.continua.backend.models.requests.UserRegisterRequestModel;
import com.poli.integracion.continua.backend.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;

  UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserEntity createUser(UserRegisterRequestModel user) {
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(user, userEntity);
    return userRepository.save(userEntity);
  }
}
