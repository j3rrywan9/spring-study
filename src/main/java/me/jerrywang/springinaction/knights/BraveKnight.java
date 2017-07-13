package me.jerrywang.springinaction.knights;

public class BraveKnight implements Knight {

  private Quest quest;

  public BraveKnight(final Quest quest) {
    this.quest = quest;
  }

  @Override
  public void embarkOnQuest() {
    quest.embark();
  }
}
