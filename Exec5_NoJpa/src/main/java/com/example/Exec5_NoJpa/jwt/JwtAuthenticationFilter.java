package com.example.Exec5_NoJpa.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws ServletException, IOException {
        try{
            String jwt = getJwtFromRequest(request);
            if(StringUtils.hasText(jwt) && TokenProvider.validateToken(jwt)){
                String userId = TokenProvider.getUserIdFromJwt(jwt);
                UserAuthentication authentication = new UserAuthentication(userId, null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }else{
                if(!StringUtils.hasText(jwt)){
                    request.setAttribute("unauthorization", "401 인증키 없음");
                }
                if ((TokenProvider.validateToken(jwt))) {
                    request.setAttribute("unauthorization", "401-001 인증키 만료");
                }
            }
        } catch(Exception e){
            System.out.println("Could not set user authentication in security context");
        }
        chain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")){
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }
}
