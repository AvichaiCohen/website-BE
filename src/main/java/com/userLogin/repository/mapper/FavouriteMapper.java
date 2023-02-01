package com.userLogin.repository.mapper;

import com.userLogin.model.Favourite;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavouriteMapper implements RowMapper<Favourite> {

    @Override
    public Favourite mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Favourite(
                rs.getLong("favourite_id"),
                rs.getLong("user_id")
        );
    }
}