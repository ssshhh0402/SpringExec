package com.example.Exec5_NoJpa.jwt;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class TokenProvider {
    private static final String AUTHORITIES_KEY="auth";
    @Value("${jwt.secret}")
    private static String secret;
    @Value("${jwt.token-validity-in-seconds")
    private static long tokenValidility;

    public static String generateToken(Authentication authentication){
        Date expire = new Date(new Date().getTime()+tokenValidility);
        return Jwts.builder()
                .setSubject((String)authentication.getPrincipal())
                .setIssuedAt(new Date())
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public static String getUserIdFromJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJwt(token)
                .getBody();
        return claims.getSubject();
    }
    public static boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJwt(token);
            return true;
        }catch(SignatureException se){
            System.out.println("SignatureException 발생했습니다!!!!!!!!!!!!!!!!!!!!!");
        }catch(MalformedJwtException mje){
            System.out.println("MalformedJwtException 발생했습니다!!!!!!!!!!!!!!!!!!!!!!");
        }catch(ExpiredJwtException eje){
            System.out.println("ExpiredJwtException 발생했습니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }catch(UnsupportedJwtException uje){
            System.out.println("UnSupportedJwtException 발생했습니다!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }catch(IllegalArgumentException iae){
            System.out.println("IllegalArgumentException 발생했습니다!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return false;
    }


}
