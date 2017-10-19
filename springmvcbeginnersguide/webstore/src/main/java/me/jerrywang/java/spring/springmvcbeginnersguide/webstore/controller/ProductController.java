package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service.IProductService;

@Controller
public class ProductController {
  @Autowired
  private IProductService productService;

  @RequestMapping("/products")
  public String list(final Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "products";
  }

  @RequestMapping("/products/{category}")
  public String getProductsByCategory(final Model model, @PathVariable("category") final String productCategory) {
    model.addAttribute("products", productService.getProductsByCategory(productCategory));
    return "products";
  }

  @RequestMapping("/update/stock")
  public String updateStock(final Model model) {
    productService.updateAllStock();
    return "redirect:/products";
  }
}
