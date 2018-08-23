package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebStoreUser implements Serializable {
  private static final long serialVersionUID = 2347661839362949373L;

  private String username;
  private String password;
  private boolean enabled;
}
