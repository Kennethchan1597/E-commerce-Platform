package com.github.ashimeru.ecommerce.ecommerce.exception;

import com.github.ashimeru.ecommerce.ecommerce.dto.ErrorDto;

public class ResourceNotFoundException extends RuntimeException{
  private final ErrorDto.Code code;
  
  public ResourceNotFoundException(ErrorDto.Code code) {
    super(code.getMessage());
    this.code = code;
  }

  public ErrorDto.Code getCode() {
    return code;
  }
}