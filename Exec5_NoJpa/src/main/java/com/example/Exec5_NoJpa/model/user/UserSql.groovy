package com.example.Exec5_NoJpa.model.user

class UserSql{
    public static final String SELECTALL= """ SELECT * FROM USER; """;
    public static final String SELECT =""" SELECT * FROM USER WHERE 1=1 """;
    public static final String findEmail = """AND email = :email""";
    public static final String findId = """AND id = :id"""
    public static final String INSERT = """ INSERT INTO user(email, pwd, times) VALUES(:Email,:Pwd, :Times)""";
    public static final String DELETEALL = """DELETE FROM user""";
    public static final String DELETE = """DELETE FROM user WHERE 1=1 """;
    public static final String DELETEID = """AND id = :id""";
    public static final String UPDATE = """UPDATE USER SET pwd = :pwd, times = :times WHERE id = :id""";
}
