package me.jerrywang.java.spring.springessentials.example2.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import me.jerrywang.java.spring.springessentials.example2.AppConfig;
import me.jerrywang.java.spring.springessentials.example2.entities.Account;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
@ActiveProfiles("test")
public class JdbcTemplateRepositoryTest {
  @Autowired
  private IAccountRepository repository;

  @Test
  public void testGetAccounts() throws Exception {
    final List<Account> accounts = repository.getAccounts();
    assertThat(accounts.size(), is(3));
  }

  @Test
  public void testGetAccount() throws Exception {
    final Account account = repository.getAccount(1L);
    assertThat(account.getId(), is(1L));
    assertThat(new BigDecimal("100.0"), is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
  }

  @Test
  public void testGetNumberOfAccoutns() throws Exception {
    assertThat(repository.getNumberOfAccounts(), is(3));
  }
}
