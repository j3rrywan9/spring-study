package me.jerrywang.java.spring.springessentials.example2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "me.jerrywang.java.spring.springessentials.example2")
public class AppConfig {
  @Autowired
  private Environment env;

  @Bean(name = "dataSource")
  @Profile("test")
  public DataSource dataSourceForTest() {
    return new EmbeddedDatabaseBuilder()
      .generateUniqueName(true)
      .setType(EmbeddedDatabaseType.HSQL)
      .setScriptEncoding("UTF-8")
      .ignoreFailedDrops(true)
      .addScript("db/sql/schema.sql")
      .addScript("db/sql/data.sql")
      .build();
  }

  @Bean(name = "transactionManager")
  @Profile("test")
  public PlatformTransactionManager transactionManagerForTest() {
    return new DataSourceTransactionManager(dataSourceForTest());
  }

  @Bean(name = "dataSource")
  @Profile("prod")
  public DataSource dataSourceForProd() {
    final HikariConfig dataSourceConfig = new HikariConfig();
    // TODO: configure dataSourceConfig with HyperSQL driver
    return new HikariDataSource();
  }

  @Bean(name = "transactionManager")
  @Profile("prod")
  public PlatformTransactionManager transactionManagerForProd() {
    return new DataSourceTransactionManager(dataSourceForProd());
  }
}
