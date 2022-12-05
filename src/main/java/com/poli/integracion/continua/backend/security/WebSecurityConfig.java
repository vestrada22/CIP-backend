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
            .mvcMatchers(HttpMethod.GET, "/movie/credits").permitAll()
            .mvcMatchers(HttpMethod.GET, "/movie/external_ids").permitAll()
            .mvcMatchers(HttpMethod.GET, "/movie/videos").permitAll()
            .mvcMatchers(HttpMethod.GET, "/movie/keywords").permitAll()
            .mvcMatchers(HttpMethod.GET, "/movie/reviews").permitAll()
            .mvcMatchers(HttpMethod.GET, "/movie/now_playing").permitAll()
            .anyRequest().authenticated();
  }
}
