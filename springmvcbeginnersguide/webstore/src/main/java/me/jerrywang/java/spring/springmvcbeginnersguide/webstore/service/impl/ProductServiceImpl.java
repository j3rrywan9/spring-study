package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.IProductRepository;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
  @Autowired
  private IProductRepository productRepository;

  @Override
  public List<Product> getAllProducts() {
    return productRepository.getAllProducts();
  }

  @Override
  public void updateAllStock() {
    final List<Product> allProducts = productRepository.getAllProducts();
    allProducts.stream()
               .filter(product -> product.getUnitsInStock() < 500)
               .forEach(product -> productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000));
  }
}
