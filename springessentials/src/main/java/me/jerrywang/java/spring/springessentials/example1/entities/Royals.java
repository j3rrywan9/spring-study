package me.jerrywang.java.spring.springessentials.example1.entities;

import org.springframework.stereotype.Component;

@Component
public class Royals implements ITeam {
  public String getName() {
    return "Kansas City Royals";
  }
}
