package me.jerrywang.java.spring.springessentials.example1.entities;

import org.springframework.stereotype.Component;

@Component
public class Cubs implements ITeam {
  public String getName() {
    return "Chicago Cubs";
  }
}
