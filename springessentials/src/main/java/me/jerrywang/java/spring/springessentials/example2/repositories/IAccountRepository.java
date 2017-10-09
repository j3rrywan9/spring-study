package me.jerrywang.java.spring.springessentials.example2.repositories;

import java.math.BigDecimal;
import java.util.List;

import me.jerrywang.java.spring.springessentials.example2.entities.Account;

public interface IAccountRepository {
  List<Account> getAccounts();

  Account getAccount(final Long id);

  int getNumberOfAccounts();

  Long createAccount(final BigDecimal initialBalance);

  int deleteAccount(final Long id);

  void updateAccount(final Account account);
}
