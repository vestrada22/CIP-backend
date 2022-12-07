package com.poli.integracion.continua.backend.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

  private final UserDetailsService userDetailsService;
  private final AuthorizationFilter authorizationFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
    AuthenticationFilter authenticationFilter = new AuthenticationFilter();
    authenticationFilter.setAuthenticationManager(authManager);
    authenticationFilter.setFilterProcessesUrl("/login");
    return http
        .cors().and().csrf().disable()
        .authorizeRequests()
        .mvcMatchers(HttpMethod.POST, "/users").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie/recommendations").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie/credits").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie/external_ids").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie/videos").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie/keywords").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie/reviews").permitAll()
        .mvcMatchers(HttpMethod.GET, "/movie/now_playing").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilter(authenticationFilter)
        .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

  @Bean
  AuthenticationManager authManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder())
        .and()
        .build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
