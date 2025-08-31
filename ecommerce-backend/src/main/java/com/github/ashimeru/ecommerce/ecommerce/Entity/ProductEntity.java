package com.github.ashimeru.ecommerce.ecommerce.Entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "products")
@Builder
@Setter
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String category;
  private String name;
  private String description;
  private double price;
  private int stock;
  private String imgUrl;
  private Date expirDate;
  private Date publishDate;
  @Setter
  private boolean isActive;
}
