package com.example.Exec5_NoJpa.model.post;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet st, int rowNum) throws SQLException{
        Post post = new Post();
        post.setId(st.getInt("id"));
        post.setContent(st.getString("content"));
        post.setTitle(st.getString("title"));
        post.setAuthor(st.getString("author"));
        return post;
    }
}
