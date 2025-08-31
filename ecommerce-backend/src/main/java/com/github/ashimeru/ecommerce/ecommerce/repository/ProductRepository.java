package com.github.ashimeru.ecommerce.ecommerce.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.ashimeru.ecommerce.ecommerce.Entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  List<ProductEntity> findAllByCategory(String category);
  Optional<ProductEntity> findByName(String name);
  List<ProductEntity> findByPriceBetween(double priceFrom, double priceTo);
}
