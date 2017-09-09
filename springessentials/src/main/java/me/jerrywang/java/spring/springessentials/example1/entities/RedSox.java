package me.jerrywang.java.spring.springessentials.example1.entities;

import org.springframework.stereotype.Service;

@Service
public class RedSox implements ITeam {
  public String getName() {
    return "Boston Red Sox";
  }
}
