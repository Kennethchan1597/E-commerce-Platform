package com.github.ashimeru.ecommerce.ecommerce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ashimeru.ecommerce.ecommerce.dto.ProductDto;

@Component
public class EntityMapper {
  @Autowired
  private ObjectMapper objectMapper;

  public ProductEntity map(ProductDto productDto) {
    return this.objectMapper.convertValue(productDto, ProductEntity.class);
  }
}
