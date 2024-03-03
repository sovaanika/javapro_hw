package org.java.homework.hw4;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createUser(Long id, String username) {
        String sql = "INSERT INTO users (id, username) VALUES (?, ?)";
        jdbcTemplate.update(sql, id, username);
    }

    @Override
    public void updateUser(Long id, String username) {
        String sql = "UPDATE users SET username = ? WHERE id = ?";
        jdbcTemplate.update(sql, username, id);
    }

    @Override
    public void deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User getUserById(Long id) throws DataAccessException {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{id}, userRowMapper());
        }
        catch (EmptyResultDataAccessException e) {
            System.out.println("!!!  В таблице нет пользователя с id = " + id + "  !!!");
            return null;
        }
        System.out.println(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, userRowMapper());
        System.out.println(users);
        return users;
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            Long id = rs.getLong("id");
            String username = rs.getString("username");
            return new User(id, username);
        };
    }
}
