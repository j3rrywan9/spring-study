package me.jerrywang.java.spring.springessentials.example2.entities;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class Account {
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private BigDecimal balance;
}
