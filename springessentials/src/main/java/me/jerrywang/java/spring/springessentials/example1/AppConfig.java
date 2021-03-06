package me.jerrywang.java.spring.springessentials.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

import me.jerrywang.java.spring.springessentials.example1.entities.*;

@Configuration
@ComponentScan(basePackages = "me.jerrywang.java.spring.springessentials.example1.entities")
public class AppConfig {
  @Autowired
  private DataSource dataSource;

  @Autowired @Qualifier("redSox")
  private ITeam homeTeam;

  @Autowired @Qualifier("cubs")
  private ITeam awayTeam;

  @Bean @Scope("prototype")
  public IGame game() {
    BaseballGame baseballGame = new BaseballGame(homeTeam, awayTeam);
    baseballGame.setDataSource(dataSource);
    return baseballGame;
  }
}
