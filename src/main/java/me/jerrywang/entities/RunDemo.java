package me.jerrywang.entities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
  public static void main(final String[] args) {
    final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    ITeam awayTeam = context.getBean("royals", Royals.class);

    IGame game1 = context.getBean("game", IGame.class);
    System.out.println(game1);

    IGame game2 = context.getBean("game", IGame.class);

    game2.setAwayTeam(awayTeam);
    System.out.println(game2);

    System.out.println(game1);

    System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
    for (final String name : context.getBeanDefinitionNames()) {
      System.out.println(name);
    }
  }
}
