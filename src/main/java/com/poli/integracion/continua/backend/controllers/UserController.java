package com.poli.integracion.continua.backend.controllers;

import com.poli.integracion.continua.backend.entities.UserEntity;
import com.poli.integracion.continua.backend.models.requests.UserRegisterRequestModel;
import com.poli.integracion.continua.backend.models.responses.UserResponse;
import com.poli.integracion.continua.backend.services.interfaces.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping()
  public UserResponse createUser(@RequestBody @Valid UserRegisterRequestModel userModel) {
    System.out.println("CREATE USER -> " + userModel);
    UserEntity user = userService.createUser(userModel);
    UserResponse userResponse = new UserResponse();
    BeanUtils.copyProperties(user, userResponse);
    return userResponse;
  }

}
