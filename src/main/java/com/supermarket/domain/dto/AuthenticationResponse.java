package com.supermarket.domain.dto;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationResponse {

  public AuthenticationResponse(String jwt) {
    this.jwt = jwt;
  }

  @Getter
  @Setter
  private String jwt;
}
