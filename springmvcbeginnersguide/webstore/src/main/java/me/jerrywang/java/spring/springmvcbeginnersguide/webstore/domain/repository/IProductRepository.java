package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository;

import java.util.List;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.WebStoreUser;

public interface IProductRepository {
  void addProduct(final Product product);
  List<Product> getAllProducts();
  Product getProductById(final String productId);
  List<Product> getProductsByCategory(final String category);
  void updateStock(final String productId, final long numberOfUnits);
  WebStoreUser getWebStoreUserByUsername(final String username);
}
