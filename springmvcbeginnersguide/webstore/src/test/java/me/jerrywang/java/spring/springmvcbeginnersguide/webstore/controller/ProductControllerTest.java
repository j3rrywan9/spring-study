package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.controller;

import java.math.BigDecimal;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.config.WebApplicationContextConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebApplicationContextConfig.class)
@WebAppConfiguration
public class ProductControllerTest {
  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  public void testGetProducts() throws Exception {
    this.mockMvc.perform(get("/products")).andExpect(model().attributeExists("products"));
  }

  @Test
  public void testGetProductById() throws Exception {
    final Product product = new Product("P1234", "iPhone 6s", new BigDecimal(500));
    product.setDescription("Apple camera");
    product.setManufacturer("Apple");
    product.setCategory("Smartphone");
    product.setUnitsInStock(450);
    this.mockMvc.perform(get("/products/product").param("id", "P1234"))
        .andExpect(model().attributeExists("product"))
        .andExpect(model().attribute("product", product));
  }
}
