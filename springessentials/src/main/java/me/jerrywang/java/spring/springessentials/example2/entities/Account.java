package me.jerrywang.java.spring.springessentials.example2.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Account {
  private Long id;
  private BigDecimal balance;
}
