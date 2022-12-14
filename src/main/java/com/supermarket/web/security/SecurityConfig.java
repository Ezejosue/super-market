package com.supermarket.web.security;

import com.supermarket.domain.service.UserDetailsService;
import com.supermarket.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;

  @Autowired
  private JwtFilterRequest jwtFilterRequest;

  private static final String[] AUTH_WHITELIST = {
      // -- Swagger UI v2
      "/v2/api-docs",
      "/swagger-resources",
      "/swagger-resources/**",
      "/configuration/ui",
      "/configuration/security",
      "/swagger-ui.html",
      "/webjars/**",
      // -- Swagger UI v3 (OpenAPI)
      "/v3/api-docs/**",
      "/swagger-ui/**"
      // other public endpoints of your API may be appended to this array
  };
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().antMatchers("/**/authenticate").permitAll()
        .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(
            SessionCreationPolicy.STATELESS);
    http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**","/configuration/ui",
        "/configuration/security","/swagger-ui.html","/swagger.json", "/swagger-ui/index.html", "/webjars/**");
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
