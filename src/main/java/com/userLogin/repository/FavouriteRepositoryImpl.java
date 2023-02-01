package com.userLogin.repository;

import com.userLogin.model.Favourite;
import com.userLogin.repository.mapper.FavouriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavouriteRepositoryImpl implements FavouriteRepository{
    private static final String FAVOURITE_TABLE_NAME = "favourite";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createFavourite(String username) {
        String sql = "INSERT INTO " + FAVOURITE_TABLE_NAME + " (username) VALUES (?)";
        jdbcTemplate.update(sql,username);
    }

    @Override
    public Favourite getFavouriteById(Long favouriteId) {
        String sql = "SELECT * FROM " + FAVOURITE_TABLE_NAME + " WHERE favourite_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new FavouriteMapper(), favouriteId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public void deleteFavouriteById(Long favouriteId) {

        String sql = "DELETE FROM " + FAVOURITE_TABLE_NAME + " WHERE favourite_id = ?";
        jdbcTemplate.update(sql, favouriteId);
    }

    @Override
    public List<Favourite> getAllFavouritesByUserId(String username) {
        String sql = "SELECT * FROM " + FAVOURITE_TABLE_NAME +"WHERE username=?";
        try {
            return jdbcTemplate.query(sql, new FavouriteMapper(),username);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}
