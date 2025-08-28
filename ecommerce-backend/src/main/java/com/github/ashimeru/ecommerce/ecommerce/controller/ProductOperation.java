package com.github.ashimeru.ecommerce.ecommerce.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.ashimeru.ecommerce.ecommerce.Entity.ProductEntity;
import com.github.ashimeru.ecommerce.ecommerce.dto.DisplayDto;
import com.github.ashimeru.ecommerce.ecommerce.dto.ProductDto;

public interface ProductOperation {
  @PostMapping(value = "/products")
  ProductEntity create(@RequestBody ProductDto productDto);

  @GetMapping(value = "/products/{id}")
  DisplayDto findById(@PathVariable Long id);

  @GetMapping(value = "/products/name/{name}")
  DisplayDto findByName(@PathVariable String name);

  @GetMapping(value = "/products/category/{category}")
  List<DisplayDto> findByCategory(@PathVariable String category);

  @GetMapping(value = "/products?minPrice=priceFrom&maxPrice=priceTo")
  List<DisplayDto> findByPrice(@RequestParam int priceFrom, @RequestParam int priceTo);

  @GetMapping(value = "/products")
  List<DisplayDto> findAll();
}
