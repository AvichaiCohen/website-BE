package com.userLogin.repository.mapper;

import com.userLogin.model.CustomUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<CustomUser> {

    @Override
    public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomUser(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("city"),
                rs.getString("country")
        );
    }
}
