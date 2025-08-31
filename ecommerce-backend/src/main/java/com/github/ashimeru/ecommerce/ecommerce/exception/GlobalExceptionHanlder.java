package com.github.ashimeru.ecommerce.ecommerce.exception;

import java.time.ZonedDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.github.ashimeru.ecommerce.ecommerce.dto.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHanlder {
    @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
    ErrorDto errorDto = ErrorDto.builder()
        .code(ex.getCode())
        .message(ex.getMessage())
        .status(ex.getCode().getHttpStatus().value())
        .timestamp(ZonedDateTime.now())
        .build();
        return ResponseEntity.status(ex.getCode().getHttpStatus()).body(errorDto);
  }
}
