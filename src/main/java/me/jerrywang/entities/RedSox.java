package me.jerrywang.entities;

import org.springframework.stereotype.Component;

@Component
public class RedSox implements ITeam {
  @Override
  public String getName() {
    return "Boston Red Sox";
  }
}
