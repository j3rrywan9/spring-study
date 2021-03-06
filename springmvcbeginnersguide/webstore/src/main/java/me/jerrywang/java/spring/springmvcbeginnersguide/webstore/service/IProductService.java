package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service;

import java.util.List;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;

public interface IProductService {
  void addProduct(final Product product);
  List<Product> getAllProducts();
  Product getProductById(final String productId);
  List<Product> getProductsByCategory(final String category);
  void updateAllStock();
}
