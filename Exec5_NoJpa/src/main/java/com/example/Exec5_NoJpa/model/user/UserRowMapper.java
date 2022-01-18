package com.example.Exec5_NoJpa.model.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet st, int rowNum) throws SQLException {
        User user = new User();
        user.setId(st.getInt("id"));
        user.setEmail(st.getString("email"));
        user.setPwd(st.getString("pwd"));
        return user;
    }
}
