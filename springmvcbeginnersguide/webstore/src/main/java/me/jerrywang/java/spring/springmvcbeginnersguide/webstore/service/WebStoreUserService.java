package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.WebStoreUser;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.IProductRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class WebStoreUserService implements UserDetailsService {
  private final IProductRepository productRepository;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final WebStoreUser webStoreUser = productRepository.getWebStoreUserByUsername(username);
    if (webStoreUser != null) {
      final List<GrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority("ROLE_WEBSTOREUSER"));

      return new User(webStoreUser.getUsername(), webStoreUser.getPassword(), authorities);
    }
    throw new UsernameNotFoundException("User '" + username + "' not found.");
  }
}
