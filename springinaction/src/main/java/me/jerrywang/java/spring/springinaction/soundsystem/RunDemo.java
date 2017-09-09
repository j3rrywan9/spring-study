package me.jerrywang.java.spring.springinaction.soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
  public static void main(final String[] args) {
    final ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);

    MediaPlayer cdPlayer = context.getBean("CDPlayer", MediaPlayer.class);

    cdPlayer.play();
  }
}
