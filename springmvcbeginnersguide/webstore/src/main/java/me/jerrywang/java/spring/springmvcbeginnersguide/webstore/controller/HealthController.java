package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
  @GetMapping("/health")
  public ResponseEntity<Void> getHealth() {
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
