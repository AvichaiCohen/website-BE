package com.userLogin.repository.mapper;

import com.userLogin.model.FavouriteList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavouriteListMapper implements RowMapper<FavouriteList> {

    @Override
    public FavouriteList mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FavouriteList(
                rs.getLong("favourite_list_id"),
                rs.getString("username"),
                rs.getLong("item_id"),
                rs.getLong("quantity_of_item")
        );
    }
}