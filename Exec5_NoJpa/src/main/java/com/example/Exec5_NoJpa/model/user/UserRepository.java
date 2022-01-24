package com.example.Exec5_NoJpa.model.user;

import groovy.util.logging.Slf4j;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    public User findById(long id){
        String query = UserSql.SELECT + UserSql.findId;
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(query, param, this.userMapper);
    }
    public User signUp(String email, String pwd){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource("Email", email)
                .addValue("Pwd", pwd);
        namedParameterJdbcTemplate.update(UserSql.INSERT, param, keyHolder);
        param = new MapSqlParameterSource("id", keyHolder.getKey().intValue());

        return namedParameterJdbcTemplate.queryForObject(UserSql.SELECT+UserSql.findId, param, this.userMapper);
    }
    public void deleteAll(){
        namedParameterJdbcTemplate.update(UserSql.DELETEALL, EmptySqlParameterSource.INSTANCE);
    }
    public void deleteById(long id){
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        namedParameterJdbcTemplate.update(UserSql.DELETE+UserSql.DELETEID, param);
    }
}
