package com.userLogin.repository;


import com.userLogin.model.FavouriteList;
import com.userLogin.repository.mapper.FavouriteListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavouriteListRepositoryImpl implements FavouriteListRepository {
    private static final String FAVOURITE_LIST_TABLE_NAME = "favourite_list";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createFavouriteList(FavouriteList favouriteList) {
        String sql = "INSERT INTO " + FAVOURITE_LIST_TABLE_NAME + " (username,item_id,quantity_of_item) VALUES (?,?,?)";
        jdbcTemplate.update(sql, favouriteList.getUsername(), favouriteList.getItemId(), favouriteList.getQuantityOfItem());
    }

    @Override
    public void deleteItemInFavouriteList(FavouriteList favouriteList) {
        String sql = "DELETE FROM " + FAVOURITE_LIST_TABLE_NAME + " WHERE username = ? AND item_id = ?";
        jdbcTemplate.update(sql, favouriteList.getUsername(), favouriteList.getItemId());
    }

    @Override
    public void deleteFavouriteList(String username) {
        String sql = "DELETE FROM " + FAVOURITE_LIST_TABLE_NAME + " WHERE username = ?";
        jdbcTemplate.update(sql, username);
    }

    @Override
    public List<FavouriteList> getAllFavouriteListByFavouriteId(String username) {
        String sql = "SELECT * FROM " + FAVOURITE_LIST_TABLE_NAME + " WHERE username = ?";
        return jdbcTemplate.query(sql, new FavouriteListMapper(),username);
    }
}
