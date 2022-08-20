package com.supermarket.domain.dto;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationRequest {

  @Getter
  @Setter
  private String username;
  @Getter
  @Setter
  private String password;

}
