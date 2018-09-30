package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.config;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  IProductRepository productRepository;

  @Override
  protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.inMemoryAuthentication().withUser("john").password("password").roles("USER");
    authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("root123").roles("USER", "ADMIN");
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");

    http.formLogin().defaultSuccessUrl("/market/products/add").failureUrl("/login?error");

    http.logout().logoutSuccessUrl("/login?logout");

    http.exceptionHandling().accessDeniedPage("/login?accessDenied");

    http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/**/add").access("hasRole('ADMIN')")
        .antMatchers("/**/market/**").access("hasRole('USER')");

    http.csrf().disable();
  }
}
