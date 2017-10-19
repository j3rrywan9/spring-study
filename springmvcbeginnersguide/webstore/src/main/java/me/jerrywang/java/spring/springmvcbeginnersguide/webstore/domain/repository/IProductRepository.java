package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository;

import java.util.List;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;

public interface IProductRepository {
  List<Product> getAllProducts();
  List<Product> getProductsByCategory(final String category);
  void updateStock(final String productId, final long numberOfUnits);
}
