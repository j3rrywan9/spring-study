package me.jerrywang.java.spring.springessentials.example2.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import me.jerrywang.java.spring.springessentials.example2.entities.*;

@Repository
public class JdbcAccountRepository implements AccountRepository {
  public List<Account> getAccounts() {
    return null;
  }

  public Account getAccount(Long id) {
    return null;
  }

  public int getNumberOfAccounts() {
    return 0;
  }

  public Long createAccount(BigDecimal initialBalance) {
    return 0L;
  }

  public int deleteAccount(Long id) {
    return 0;
  }

  public void updateAccount(Account account) {

  }
}
