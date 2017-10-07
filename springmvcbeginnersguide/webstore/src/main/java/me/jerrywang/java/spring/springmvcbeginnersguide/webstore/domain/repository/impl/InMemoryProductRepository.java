package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.IProductRepository;

@Repository
public class InMemoryProductRepository implements IProductRepository {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Product> getAllProducts() {
    Map<String, Object> params = new HashMap<>();
    List<Product> results = jdbcTemplate.query("select * from products", params, new ProductMapper());
    return results;
  }

  private static final class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
      Product product = new Product();
      product.setProductId(rs.getString("id"));
      product.setName(rs.getString("name"));
      product.setDescription(rs.getString("description"));
      product.setUnitPrice(rs.getBigDecimal("unit_price"));
      product.setManufacturer(rs.getString("manufacturer"));
      product.setCategory(rs.getString("category"));
      product.setUnitsInOrder(rs.getLong("units_in_stock"));
      product.setUnitsInOrder(rs.getLong("units_in_order"));
      product.setDiscontinued(rs.getBoolean("discontinued"));

      return product;
    }
  }

}
