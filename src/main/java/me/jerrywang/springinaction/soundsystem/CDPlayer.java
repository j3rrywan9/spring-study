package me.jerrywang.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  @Autowired
  public CDPlayer(final CompactDisc cd) {
    this.cd = cd;
  }

  @Autowired
  public void setCompactDisc(final CompactDisc cd) {
    this.cd = cd;
  }

  @Override
  public void play() {
    cd.play();
  }
}
