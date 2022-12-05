package com.poli.integracion.continua.backend.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable();
    http.authorizeHttpRequests().mvcMatchers(HttpMethod.POST, "/users").permitAll()
            .mvcMatchers(HttpMethod.GET, "/movie").permitAll()
            .mvcMatchers(HttpMethod.GET, "/movie/recommendations").permitAll()
            .anyRequest().authenticated();
  }
}
