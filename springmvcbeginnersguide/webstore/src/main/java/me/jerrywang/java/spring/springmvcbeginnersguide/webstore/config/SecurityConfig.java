package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.config;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.IProductRepository;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service.WebStoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  IProductRepository productRepository;

  @Override
  protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(new WebStoreUserService(productRepository));
  }
}
