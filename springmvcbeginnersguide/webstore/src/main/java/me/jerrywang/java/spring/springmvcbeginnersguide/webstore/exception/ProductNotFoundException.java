package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 9136274734362232851L;

  private final String productId;
}
