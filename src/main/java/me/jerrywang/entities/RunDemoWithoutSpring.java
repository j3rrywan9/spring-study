package me.jerrywang.entities;

public class RunDemoWithoutSpring {
  public static void main(final String[] args) {
    ITeam redSox = new RedSox();
    ITeam cubs = new Cubs();
    IGame game = new BaseballGame(redSox, cubs);
    System.out.println(game.playGame());
  }
}
