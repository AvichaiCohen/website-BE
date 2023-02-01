package com.userLogin.repository;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "user";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (username, password,first_name,last_name,email,phone,city,country) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, customUser.getUsername(), customUser.getPassword(),customUser.getFirstName(),customUser.getLastName(),customUser.getEmail(),customUser.getPhone(),customUser.getCity(),customUser.getCountry());
    }

    @Override
    public void updateUserDetailsByAuth(CustomUser customUser,String username) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?,last_name=?,email=?,phone=?,city=?,country=? " + "WHERE username=?";
        jdbcTemplate.update(sql, customUser.getFirstName(), customUser.getLastName(),customUser.getEmail(),customUser.getPhone(),customUser.getCity(),customUser.getCountry(),username);
    }

    @Override
    public void deleteUserById(String username) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE username = ?";
        jdbcTemplate.update(sql, username);
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}


