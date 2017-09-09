package me.jerrywang.java.spring.springessentials.example2.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.jerrywang.java.spring.springessentials.example2.entities.Account;
import me.jerrywang.java.spring.springessentials.example2.repositories.AccountRepository;

@Service
@Transactional
@Profile("test")
public class AccountService {

  @Autowired
  private AccountRepository repository;

  @Transactional
  public BigDecimal getBalance(Long id) {
    return repository.getAccount(id).getBalance();
  }

  public BigDecimal deposit(Long id, BigDecimal amount) {
    Account account = repository.getAccount(id);
    BigDecimal newBalance = account.getBalance().add(amount);
    account.setBalance(newBalance);
    return newBalance;
  }

  public BigDecimal withdraw(Long id, BigDecimal amount) {
    return deposit(id, amount.negate());
  }
}
