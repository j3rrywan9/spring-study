package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product implements Serializable {
  private static final long serialVersionUID = -7596961173064726280L;

  private String productId;
  private String name;
  private BigDecimal unitPrice;
  private String description;
  private String manufacturer;
  private String category;
  private long unitsInStock;
  private long unitsInOrder;
  private boolean discontinued;
  private String condition;

  public Product(final String productId, final String name, final BigDecimal unitPrice) {
    this.productId = productId;
    this.name = name;
    this.unitPrice = unitPrice;
  }
}
