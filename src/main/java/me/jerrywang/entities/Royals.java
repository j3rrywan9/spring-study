package me.jerrywang.entities;

import org.springframework.stereotype.Component;

@Component
public class Royals implements ITeam {
  @Override
  public String getName() {
    return "Kansas City Royals";
  }
}
