package com.poli.integracion.continua.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poli.integracion.continua.backend.models.requests.UserLoginRequestModel;
import com.poli.integracion.continua.backend.services.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    UserLoginRequestModel userModel;
    try {
      userModel = new ObjectMapper().readValue(request.getReader(), UserLoginRequestModel.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
        userModel.getEmail(),
        userModel.getPassword(),
        Collections.emptyList());

    return getAuthenticationManager().authenticate(usernamePAT);
  }

  @Override
  public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication auth) throws IOException {
    UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();
    String token = TokenUtils.createToken(user.getName(), user.getUsername());
    log.info(token);
    response.addHeader("Authorization", "Bearer " + token);
    response.getWriter().flush();
  }
}
