package com.github.ashimeru.ecommerce.ecommerce.controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.ashimeru.ecommerce.ecommerce.Entity.ProductEntity;
import com.github.ashimeru.ecommerce.ecommerce.controller.ProductOperation;
import com.github.ashimeru.ecommerce.ecommerce.dto.DisplayDto;
import com.github.ashimeru.ecommerce.ecommerce.dto.DtoMapper;
import com.github.ashimeru.ecommerce.ecommerce.dto.ProductDto;
import com.github.ashimeru.ecommerce.ecommerce.service.ProductService;

@RestController
public class ProductController implements ProductOperation{
  @Autowired
  private ProductService productService;
  @Autowired
  private DtoMapper dtoMapper;

  public ProductEntity create(@RequestBody ProductDto productDto) {
    return this.productService.save(productDto);
  }

  public DisplayDto findById(@PathVariable Long id) {
    ProductDto productDto = this.productService.findProductById(id);
    return this.dtoMapper.map(productDto);
  }

  
  public DisplayDto findByName(@PathVariable String name) {
    ProductDto productDto = this.productService.findByName(name);
    return this.dtoMapper.map(productDto);
  }

  
  public List<DisplayDto> findByCategory(@PathVariable String category) {
    List<ProductDto> productDtos = this.productService.findAllByCategory(category);
    return productDtos.stream().map(c -> this.dtoMapper.map(c)).toList();
  }

  public List<DisplayDto> findByPrice(int priceFrom, int priceTo) {
    List<ProductDto> productDtos = this.productService.findByPrice(priceFrom, priceTo);
    return productDtos.stream().map(c -> this.dtoMapper.map(c)).toList();
  }
  
  public List<DisplayDto> findAll() {
    List<ProductDto> productDtos = this.productService.findAll();
    return productDtos.stream().map(c -> this.dtoMapper.map(c)).toList();
  }


  // demo
  // demo
  // demo
  // demo
  // demo
  // demo
  // demo
  

}
