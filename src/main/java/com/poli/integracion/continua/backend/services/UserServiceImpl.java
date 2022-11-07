package com.poli.integracion.continua.backend.services;

import com.poli.integracion.continua.backend.entities.UserEntity;
import com.poli.integracion.continua.backend.models.requests.UserRegisterRequestModel;
import com.poli.integracion.continua.backend.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public UserEntity createUser(UserRegisterRequestModel user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    BeanUtils.copyProperties(user, userEntity);
    return userRepository.save(userEntity);
  }
}
