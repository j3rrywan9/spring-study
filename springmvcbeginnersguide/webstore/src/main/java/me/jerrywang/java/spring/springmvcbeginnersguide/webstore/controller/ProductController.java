package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.exception.NoProductsFoundUnderCategoryException;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.exception.ProductNotFoundException;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
  @Autowired
  private IProductService productService;

  @RequestMapping("/products/product")
  public String getProductById(final Model model, @RequestParam("id") final String productId) {
    model.addAttribute("product", productService.getProductById(productId));
    return "product";
  }

  @RequestMapping("/products")
  public String list(final Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "products";
  }

  @RequestMapping("/products/{category}")
  public String getProductsByCategory(final Model model, @PathVariable("category") final String productCategory) {
    final List<Product> products = productService.getProductsByCategory(productCategory);
    if (products == null || products.isEmpty()) {
      throw new NoProductsFoundUnderCategoryException();
    }
    model.addAttribute("products", products);
    return "products";
  }

  @RequestMapping("/update/stock")
  public String updateStock(final Model model) {
    productService.updateAllStock();
    return "redirect:/products";
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public ModelAndView handleError(final HttpServletRequest request, final ProductNotFoundException exception) {
    final ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("invalidProductId", exception.getProductId());
    modelAndView.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
    modelAndView.addObject("exception", exception);
    modelAndView.setViewName("productNotFound");
    return modelAndView;
  }
}
