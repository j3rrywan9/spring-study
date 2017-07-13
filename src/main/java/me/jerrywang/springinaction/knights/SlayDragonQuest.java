package me.jerrywang.springinaction.knights;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

  private PrintStream stream;

  public SlayDragonQuest(final PrintStream stream) {
    this.stream = stream;
  }

  @Override
  public void embark() {
    stream.println("Embarking on quest to slay the dragon!");
  }
}
