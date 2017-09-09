package me.jerrywang.java.spring.springessentials.example1.entities;

import javax.sql.DataSource;

public class BaseballGame implements IGame {
  private ITeam homeTeam;
  private ITeam awayTeam;
  private DataSource dataSource;

  public BaseballGame() {}

  // Constructor-based injection
  public BaseballGame(ITeam homeTeam, ITeam awayTeam) {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  // Setter-based injection
  public void setHomeTeam(ITeam homeTeam) {
    this.homeTeam = homeTeam;
  }

  public ITeam getHomeTeam() {
    return homeTeam;
  }

  // Setter-based injection
  public void setAwayTeam(ITeam awayTeam) {
    this.awayTeam = awayTeam;
  }

  public ITeam getAwayTeam() {
    return awayTeam;
  }

  public String playGame() {
    return Math.random() < 0.5 ? getHomeTeam().getName() : getAwayTeam().getName();
  }

  @Override
  public String toString() {
    return String.format("Game between %s at %s", awayTeam.getName(), homeTeam.getName());
  }
}
