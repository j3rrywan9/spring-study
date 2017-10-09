package me.jerrywang.java.spring.springessentials.example2.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.jerrywang.java.spring.springessentials.example2.entities.Account;
import me.jerrywang.java.spring.springessentials.example2.repositories.IAccountRepository;

@Service
@Transactional
@Profile("test")
public class AccountService {

  @Autowired
  private IAccountRepository repository;

  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public BigDecimal getBalance(final Long id) {
    return repository.getAccount(id).getBalance();
  }

  public BigDecimal deposit(final Long id, final BigDecimal amount) {
    final Account account = repository.getAccount(id);
    final BigDecimal newBalance = account.getBalance().add(amount);
    account.setBalance(newBalance);
    repository.updateAccount(account);
    return newBalance;
  }

  public BigDecimal withdraw(final Long id, final BigDecimal amount) {
    return deposit(id, amount.negate());
  }

  public void transfer(final Long fromId, final Long toId, final BigDecimal amount) {
    withdraw(fromId, amount);
    deposit(toId, amount);
  }
}
