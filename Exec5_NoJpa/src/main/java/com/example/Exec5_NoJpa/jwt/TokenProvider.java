package com.example.Exec5_NoJpa.jwt;

import com.example.Exec5_NoJpa.model.user.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenProvider {
    private static final String AUTHORITIES_KEY="auth";
    private static final String secret = "secret";
    private static final long tokenValidility = 60 * 60;

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
        Claims claims = Jwts
                .parser()
                .setSigningKey(secret)
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
