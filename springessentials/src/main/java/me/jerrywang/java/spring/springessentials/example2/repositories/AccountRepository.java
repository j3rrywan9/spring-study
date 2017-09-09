package me.jerrywang.java.spring.springessentials.example2.repositories;

import java.math.BigDecimal;
import java.util.List;

import me.jerrywang.java.spring.springessentials.example2.entities.Account;

public interface AccountRepository {
  List<Account> getAccounts();

  Account getAccount(Long id);

  int getNumberOfAccounts();

  Long createAccount(BigDecimal initialBalance);

  int deleteAccount(Long id);

  void updateAccount(Account account);
}
