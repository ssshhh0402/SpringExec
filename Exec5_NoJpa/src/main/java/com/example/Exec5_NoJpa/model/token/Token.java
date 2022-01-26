package com.example.Exec5_NoJpa.model.token;

public class Token {
    public static final class Request{
        private String email;
        private String pwd;

        public Request(){

        }
        public Request(String a, String b){
            this.email = a;
            this.pwd = b;
        }
        public String getEmail(){
            return this.email;
        }
        public void setId(String a){
            this.email = a;
        }
        public String getPwd(){
            return this.pwd;
        }
        public void setPwd(String a){
            this.pwd = a;
        }
    }
    public static final class Response{
        private String token;
        public Response(String a){
            this.token = a;
        }
        public String getToken(){
            return this.token;
        }
        public void setToken(String a){
            this.token = a;
        }
    }
}
