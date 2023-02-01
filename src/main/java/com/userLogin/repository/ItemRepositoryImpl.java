package com.userLogin.repository;

import com.userLogin.model.Item;
import com.userLogin.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final String ITEM_TABLE_NAME = "item";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title,photo,price,in_stock) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,item.getTitle(),item.getPhoto(),item.getPrice(),item.getInStock());
    }

    @Override
    public Item getItemById(Long itemId) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE item_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new ItemMapper(), itemId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
    @Override
    public void updateItemById(Long itemId,Item item) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET title=?,photo=?,price=?,in_stock=? " + "WHERE item_id=?";
        jdbcTemplate.update(sql,item.getTitle(),item.getPhoto(),item.getPrice(),item.getInStock(),itemId);

    }

    @Override
    public void deleteItemById(Long itemId) {
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE item_id = ?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME ;
        try {
            return jdbcTemplate.query(sql, new ItemMapper());
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}
