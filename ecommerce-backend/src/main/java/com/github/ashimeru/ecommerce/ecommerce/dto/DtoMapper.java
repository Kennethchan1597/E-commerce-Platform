package com.github.ashimeru.ecommerce.ecommerce.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ashimeru.ecommerce.ecommerce.Entity.ProductEntity;

@Component
public class DtoMapper {
  @Autowired
  private ObjectMapper objectMapper;

  public ProductDto map(ProductEntity productEntity) {
    return this.objectMapper.convertValue(productEntity, ProductDto.class);
  }

  public DisplayDto map(ProductDto productDto) {
    return this.objectMapper.convertValue(productDto, DisplayDto.class);
  }
}
