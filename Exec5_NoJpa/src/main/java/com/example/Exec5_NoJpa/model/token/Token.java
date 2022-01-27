package com.example.Exec5_NoJpa.model.token;

public class Token {
    public static final class Request{
        private String email12;
        private String pwd123;

        public Request(){

        }
        public Request(String a, String b){
            this.email12 = a;
            this.pwd123 = b;
        }
        public String getEmail(){
            return this.email12;
        }
        public void setId(String a){
            this.email12 = a;
        }
        public String getPwd(){
            return this.pwd123;
        }
        public void setPwd(String a){
            this.pwd123 = a;
        }
    }
    public static final class Response{
        private String token;
        public Response(){

        }
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
