package com.poli.integracion.continua.backend.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
  /**
   * Same contract as for {@code doFilter}, but guaranteed to be
   * just invoked once per request within a single request thread.
   * See {@link #shouldNotFilterAsyncDispatch()} for details.
   * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
   * default ServletRequest and ServletResponse ones.
   *
   * @param request
   * @param response
   * @param filterChain
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String bearerToken = request.getHeader("Authorization");
    if (!Objects.isNull(bearerToken) && bearerToken.startsWith("Bearer")) {
      String token = bearerToken.replace("Bearer ", "");
      UsernamePasswordAuthenticationToken usernamePAT = TokenUtils.getAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(usernamePAT);
    }
    filterChain.doFilter(request, response);
  }
}
