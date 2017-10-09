package me.jerrywang.java.spring.springessentials.example2.services;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import me.jerrywang.java.spring.springessentials.example2.AppConfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
@ActiveProfiles("test")
public class AccountServiceTest {
  @Autowired
  private AccountService service;

  @Test
  public void testDeposit() throws Exception {
    final BigDecimal start = service.getBalance(1L);
    final BigDecimal amount = new BigDecimal("50.0");
    service.deposit(1L, amount);
    final BigDecimal finish = start.add(amount);
    assertThat(finish, is(closeTo(service.getBalance(1L), new BigDecimal("0.01"))));
  }

  @Test
  public void testWithdraw() throws Exception {
    final BigDecimal start = service.getBalance(1L);
    final BigDecimal amount = new BigDecimal("50.0");
    service.withdraw(1L, amount);
    final BigDecimal finish = start.subtract(amount);
    assertThat(finish, is(closeTo(service.getBalance(1L), new BigDecimal("0.01"))));
  }
}
