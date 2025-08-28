package com.github.ashimeru.ecommerce.ecommerce.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.ashimeru.ecommerce.ecommerce.Entity.EntityMapper;
import com.github.ashimeru.ecommerce.ecommerce.Entity.ProductEntity;
import com.github.ashimeru.ecommerce.ecommerce.dto.DtoMapper;
import com.github.ashimeru.ecommerce.ecommerce.dto.ErrorDto;
import com.github.ashimeru.ecommerce.ecommerce.dto.ErrorDto.Code;
import com.github.ashimeru.ecommerce.ecommerce.dto.ProductDto;
import com.github.ashimeru.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.github.ashimeru.ecommerce.ecommerce.repository.ProductRepository;
import com.github.ashimeru.ecommerce.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  private DtoMapper dtoMapper;

  public ProductEntity save(ProductDto productDto) {
    return this.productRepository.save(this.entityMapper.map(productDto));
  }

public ProductEntity update(Long id, ProductDto productDto) {
    ProductEntity existing = productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(ErrorDto.Code.Product_NOT_FOUND));

    existing.setName(productDto.getName());
    existing.setDescription(productDto.getDescription());
    existing.setCategory(productDto.getCategory());
    existing.setPrice(productDto.getPrice());
    existing.setStock(productDto.getStock());
    existing.setImgUrl(productDto.getImgUrl());
    existing.setExpirDate(productDto.getExpirDate());
    existing.setPublishDate(productDto.getPublishDate());
    existing.setActive(true);
    return productRepository.save(existing);
}

  public Boolean delete(Long id) {
    ProductEntity productEntity = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Code.Product_NOT_FOUND));
    productEntity.setActive(false);
    this.productRepository.save(productEntity);
    return true;
  }

  public ProductDto findProductById(Long id) {
    ProductEntity productEntity = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Code.Product_NOT_FOUND));
    return this.dtoMapper.map(productEntity);
  }

  public List<ProductDto> findAllByCategory(String category) {
    List<ProductEntity> productEntitys = this.productRepository.findAllByCategory(category);
    return productEntitys.stream().map(c -> this.dtoMapper.map(c)).toList();
  }
  
  public ProductDto findByName(String name) {
    ProductEntity productEntity = this.productRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException(Code.Product_NOT_FOUND));
    return this.dtoMapper.map(productEntity);
  }

  public List<ProductDto> findByPrice(int priceFrom, int priceTo) {
    List<ProductEntity> productEntitys = this.productRepository.findByPrice(priceFrom, priceTo);
    return productEntitys.stream().map(c -> this.dtoMapper.map(c)).toList();
  }

  public List<ProductDto> findAll() {
    List<ProductEntity> products = this.productRepository.findAll();
    return products.stream().map(c -> this.dtoMapper.map(c)).toList();
  }
}
