package me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.Product;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.WebStoreUser;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.domain.repository.IProductRepository;
import me.jerrywang.java.spring.springmvcbeginnersguide.webstore.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements IProductRepository {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void addProduct(final Product product) {
    final String SQL = "INSERT INTO PRODUCTS (ID, "
        + "NAME,"
        + "DESCRIPTION,"
        + "UNIT_PRICE,"
        + "MANUFACTURER,"
        + "CATEGORY,"
        + "CONDITION,"
        + "UNITS_IN_STOCK,"
        + "UNITS_IN_ORDER,"
        + "DISCONTINUED) "
        + "VALUES (:id, :name, :desc, :price, :manufacturer, :category, :condition, :inStock, :inOrder, :discontinued)";

    final Map<String, Object> params = new HashMap<>();
    params.put("id", product.getProductId());
    params.put("name", product.getName());
    params.put("desc", product.getDescription());
    params.put("price", product.getUnitPrice());
    params.put("manufacturer", product.getManufacturer());
    params.put("category", product.getCategory());
    params.put("condition", product.getCondition());
    params.put("inStock", product.getUnitsInStock());
    params.put("inOrder", product.getUnitsInOrder());
    params.put("discontinued", product.isDiscontinued());

    jdbcTemplate.update(SQL, params);
  }

  @Override
  public List<Product> getAllProducts() {
    Map<String, Object> params = new HashMap<>();
    List<Product> results = jdbcTemplate.query("select * from products", params, new ProductMapper());
    return results;
  }

  @Override
  public Product getProductById(final String productId) {
    String SQL = "select * from products where id = :id";
    final Map<String, Object> params = new HashMap<>();
    params.put("id", productId);
    try {
      return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
    } catch (final DataAccessException e) {
      throw new ProductNotFoundException(productId);
    }
  }

  @Override
  public List<Product> getProductsByCategory(final String category) {
    String SQL = "select * from products where category = :category";
    final Map<String, Object> params = new HashMap<>();
    params.put("category", category);
    return jdbcTemplate.query(SQL, params, new ProductMapper());
  }

  @Override
  public void updateStock(final String productId, final long numberOfUnits) {
    final String SQL = "update products set units_in_stock = :unitsInStock where id = :id";
    final Map<String, Object> params = new HashMap<>();
    params.put("unitsInStock", numberOfUnits);
    params.put("id", productId);
    jdbcTemplate.update(SQL, params);
  }

  @Override
  public WebStoreUser getWebStoreUserByUsername(final String username) {
    final String SQL = "select * from users where username = :username";
    final Map<String, Object> params = new HashMap<>();
    params.put("username", username);
    return jdbcTemplate.queryForObject(SQL, params, new WebStoreUserMapper());
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
      product.setUnitsInStock(rs.getLong("units_in_stock"));
      product.setUnitsInOrder(rs.getLong("units_in_order"));
      product.setDiscontinued(rs.getBoolean("discontinued"));

      return product;
    }
  }

  private static final class WebStoreUserMapper implements RowMapper<WebStoreUser> {
    public WebStoreUser mapRow(ResultSet rs, int rowNum) throws SQLException {
      WebStoreUser user = new WebStoreUser();
      user.setUsername(rs.getString("username"));
      user.setPassword(rs.getString("password"));

      return user;
    }
  }
}
