package me.jerrywang.entities;

import javax.sql.DataSource;

public class BaseballGame implements IGame {
  private ITeam homeTeam;
  private ITeam awayTeam;
  private DataSource dataSource;

  public BaseballGame() {}

  public BaseballGame(ITeam homeTeam, ITeam awayTeam) {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void setHomeTeam(ITeam homeTeam) {
    this.homeTeam = homeTeam;
  }

  @Override
  public ITeam getHomeTeam() {
    return homeTeam;
  }

  public void setAwayTeam(ITeam awayTeam) {
    this.awayTeam = awayTeam;
  }

  @Override
  public ITeam getAwayTeam() {
    return awayTeam;
  }

  @Override
  public String playGame() {
    return Math.random() < 0.5 ? getHomeTeam().getName() : getAwayTeam().getName();
  }

  @Override
  public String toString() {
    return String.format("Game between %s at %s", awayTeam.getName(), homeTeam.getName());
  }
}
