package com.example.Exec5_NoJpa.model.user

class UserSql{
    public static final String SELECTALL= """ SELECT * FROM USER; """;
    public static final String SELECT =""" SELECT * FROM USER WHERE 1=1 """;
    public static final String findEmail = """AND email = :email""";

}
