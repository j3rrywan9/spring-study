package me.jerrywang.java.spring.springessentials.example2.repositories;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import me.jerrywang.java.spring.springessentials.example2.entities.*;

@Repository
@Profile("test")
public class JdbcAccountRepository implements IAccountRepository {
  private JdbcTemplate template;
  private static long nextId = 4;

  @Autowired
  public JdbcAccountRepository(final DataSource dataSource) {
    template = new JdbcTemplate(dataSource);
  }

  public List<Account> getAccounts(){
    final String sqlText = "select * from account";
    return template.query(sqlText, new AccountMapper());
  }

  @Override
  public Account getAccount(final Long id) {
    final String sqlText = "select * from account where id=?";
    return template.queryForObject(sqlText, new AccountMapper(), id);
  }

  @Override
  public int getNumberOfAccounts() {
    final String sqlText = "select count(*) from account";
    return template.queryForObject(sqlText, Integer.class);
  }

  @Override
  public Long createAccount(final BigDecimal initialBalance) {
    final String sqlText = "insert into account(id, balance) values(?, ?)";
    final long id = nextId++;
    final int uc = template.update(sqlText, id, initialBalance);
    return id;
  }

  @Override
  public int deleteAccount(final Long id) {
    final String sqlText = "delete from account where id = ?";
    return template.update(sqlText, id);
  }

  @Override
  public void updateAccount(final Account account) {
    final String sqlText = "update account set balance = ? where id = ?";
    template.update(sqlText, account.getBalance(), account.getId());
  }

  private class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(final ResultSet resultSet, final int i) throws SQLException {
      return new Account(resultSet.getLong("id"), resultSet.getBigDecimal("balance"));
    }
  }
}
