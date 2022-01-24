package com.example.Exec5_NoJpa.model.post

class PostSql {
    public static final String SELECTALL = """select * from post""";
    public static final String FIND = """ select * from post where 1=1 """
    public static final String INSERT = """ insert into post(title,content,author) values (:title, :content, :author)""";
    public static final String DELETE = """ DELETE FROM post where 1=1 """
    public static final String BYID = """and id = :id""";
    public static final String UPDATE = """UPDATE POST SET title = :title, content = :content where id = :id""";
}
