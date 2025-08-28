package com.github.ashimeru.ecommerce.ecommerce.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DisplayDto {
  private String name;
  private String description;
  private String category;
  private double price;
  private String imgUrl;
  private int stock;
  private Date expirDate;
  private Date publishDate;
}
