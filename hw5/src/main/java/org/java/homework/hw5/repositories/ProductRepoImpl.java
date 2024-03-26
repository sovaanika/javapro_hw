package org.java.homework.hw5.repositories;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.java.homework.hw5.entities.ProductEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ProductRepoImpl implements ProductRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public List<ProductEntity> getProductsByUserId(Long userId) {
        String sql = "SELECT * FROM products WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new ProductMapper());
    }

    @Override
    public List<ProductEntity> getProductByProductId(Long productId) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        return jdbcTemplate.query(sql, new Object[]{productId}, new ProductMapper());
    }

    private static final class ProductMapper implements RowMapper<ProductEntity> {
        @Override
        public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ProductEntity(rs.getLong("product_id"), rs.getLong("account_number"), rs.getLong("balance"), ProductEntity.ProductType.valueOf(rs.getString("product_type")));
        }
    }
}
