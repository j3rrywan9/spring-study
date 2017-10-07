package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.IProductRepository;

@Controller
public class ProductController {
  @Autowired
  private IProductRepository productRepository;

  @RequestMapping("/products")
  public String list(final Model model) {
    model.addAttribute("products", productRepository.getAllProducts());
    return "products";
  }
}
