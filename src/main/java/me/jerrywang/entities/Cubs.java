package me.jerrywang.entities;

import org.springframework.stereotype.Component;

@Component
public class Cubs implements ITeam {
  @Override
  public String getName() {
    return "Chicago Cubs";
  }
}
