package com.github.ashimeru.ecommerce.ecommerce.service;

import java.util.List;
import com.github.ashimeru.ecommerce.ecommerce.Entity.ProductEntity;
import com.github.ashimeru.ecommerce.ecommerce.dto.ProductDto;

public interface ProductService {
  ProductEntity save(ProductDto productDto);

  ProductEntity update(Long id, ProductDto productDto);

  Boolean delete(Long id);

  ProductDto findProductById(Long id);

  List<ProductDto> findAllByCategory(String category);

  ProductDto findByName(String name);

  List<ProductDto> findByPrice(int priceFrom, int priceTo);

  List<ProductDto> findAll();
}
