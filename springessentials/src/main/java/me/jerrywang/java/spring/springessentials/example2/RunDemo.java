package me.jerrywang.java.spring.springessentials.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
  public static void main(final String[] args) {
    final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
    for (final String name : context.getBeanDefinitionNames()) {
      System.out.println(name);
    }
  }
}
