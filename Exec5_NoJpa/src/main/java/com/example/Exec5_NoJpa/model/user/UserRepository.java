package com.example.Exec5_NoJpa.model.user;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepository(NamedParameterJdbcTemplate a){
        this.namedParameterJdbcTemplate = a;
    }
    public List<User> findALl(){
        String sql = "select * from user";

        RowMapper<User> userMapper = (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPwd(rs.getString("pwd"));
            return user;
        };
        return namedParameterJdbcTemplate.query(sql,new MapSqlParameterSource(),userMapper);

    }
}
