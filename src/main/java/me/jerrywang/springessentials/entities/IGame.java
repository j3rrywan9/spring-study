package me.jerrywang.springessentials.entities;

public interface IGame {
  void setHomeTeam(ITeam team);
  ITeam getHomeTeam();
  void setAwayTeam(ITeam team);
  ITeam getAwayTeam();
  String playGame();
}
