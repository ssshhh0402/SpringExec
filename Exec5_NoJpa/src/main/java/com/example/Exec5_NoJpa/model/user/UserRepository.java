package com.example.Exec5_NoJpa.model.user;

import groovy.util.logging.Slf4j;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRowMapper userRowMapper;
    private final RowMapper<User> userMapper;
    public UserRepository(NamedParameterJdbcTemplate a){
        this.namedParameterJdbcTemplate = a;
        this.userRowMapper = new UserRowMapper();
        this.userMapper = BeanPropertyRowMapper.newInstance(User.class);
    }

    public List<User> findAll(){
        return namedParameterJdbcTemplate.query(UserSql.SELECTALL, EmptySqlParameterSource.INSTANCE,this.userRowMapper);
    }
    public User findByEmail(String email){
        String query = UserSql.SELECT + UserSql.findEmail;
        SqlParameterSource param = new MapSqlParameterSource("email", email);
        return namedParameterJdbcTemplate.queryForObject(query,param, this.userMapper);
    }
}
