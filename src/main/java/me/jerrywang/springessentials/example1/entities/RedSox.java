package me.jerrywang.springessentials.example1.entities;

import org.springframework.stereotype.Service;

@Service
public class RedSox implements ITeam {
  @Override
  public String getName() {
    return "Boston Red Sox";
  }
}
