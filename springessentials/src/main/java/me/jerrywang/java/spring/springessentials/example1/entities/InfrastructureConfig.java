package me.jerrywang.java.spring.springessentials.example1.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class InfrastructureConfig {
  @Bean
  public DataSource dataSource() {
    return new DriverManagerDataSource();
  }
}
