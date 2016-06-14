package me.jerrywang.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BaseballGameTest {
  @Autowired
  private ApplicationContext ctx;

  @Autowired
  private Game game;

  @Test
  public void testPlayGame() throws Exception {
    String home = game.getHomeTeam().getName();
    String away = game.getAwayTeam().getName();

    String result = game.playGame();

    assertTrue(result.contains(home) || result.contains(away));
  }

  @Test
  public void testGetAndSetHomeTeam() throws Exception {
    Team royals = ctx.getBean("royals", Team.class);
    game.setHomeTeam(royals);
    assertEquals(royals.getName(), game.getHomeTeam().getName());
  }
}
