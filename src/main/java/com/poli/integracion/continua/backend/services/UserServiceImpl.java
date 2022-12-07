package com.poli.integracion.continua.backend.services;

import com.poli.integracion.continua.backend.entities.UserEntity;
import com.poli.integracion.continua.backend.models.requests.UserRegisterRequestModel;
import com.poli.integracion.continua.backend.repositories.UserRepository;
import com.poli.integracion.continua.backend.services.interfaces.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
  public UserDetails loadUserByUsername(String username) {
    UserEntity user = userRepository.findByEmail(username);
    if (user == null ) {
      throw new UsernameNotFoundException("User with email " + username + " doesn't exist.");
    }
    return new UserDetailsImpl(user);
  }

  @Override
  public UserEntity createUser(UserRegisterRequestModel user) {
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(user, userEntity);
    userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(userEntity);
  }
}
