package com.example.Exec5_NoJpa.model.user;

import groovy.util.logging.Slf4j;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRowMapper userRowMapper;
    public UserRepository(NamedParameterJdbcTemplate a){
        this.namedParameterJdbcTemplate = a;
        this.userRowMapper = new UserRowMapper();
    }

    public List<User> findAll(){
        return namedParameterJdbcTemplate.query(UserSql.SELECT, EmptySqlParameterSource.INSTANCE,this.userRowMapper);
    }
}
