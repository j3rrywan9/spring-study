package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service;

import java.util.List;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;

public interface IProductService {
  List<Product> getAllProducts();
  void updateAllStock();
}
