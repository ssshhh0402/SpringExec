package com.example.Exec5_NoJpa.model.post;

import com.example.Exec5_NoJpa.model.dto.post.PostSaveRequestDto;
import com.example.Exec5_NoJpa.model.dto.post.PostUpdateRequestDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final PostRowMapper rowMapper;
    private final RowMapper<Post> postMapper;
    public PostRepository(NamedParameterJdbcTemplate namedParameterJdbcTEmplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTEmplate;
        this.rowMapper = new PostRowMapper();
        this.postMapper = BeanPropertyRowMapper.newInstance(Post.class);
    }

    public List<Post> getAll(){
        return namedParameterJdbcTemplate.query(PostSql.SELECTALL, EmptySqlParameterSource.INSTANCE, this.rowMapper);
    }

    public Post findById(long id){
        String query = PostSql.FIND + PostSql.BYID;
        SqlParameterSource params = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(query, params, this.postMapper);
    }
    public Boolean save(PostSaveRequestDto dto, String email){
        try{
            SqlParameterSource params = new MapSqlParameterSource("title", dto.getTitle())
                    .addValue("content", dto.getContent())
                    .addValue("author", email);
            namedParameterJdbcTemplate.update(PostSql.INSERT, params);
            return true;
        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
    public void delete(long id){
        String query = PostSql.DELETE + PostSql.BYID;
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        namedParameterJdbcTemplate.update(query, param);
    }
    public void update(long id, String title, String content){
        String query = PostSql.UPDATE;
        SqlParameterSource param = new MapSqlParameterSource("title", title)
                .addValue("content", content)
                .addValue("id", id);
        namedParameterJdbcTemplate.update(query, param);
    }
}
