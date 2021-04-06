package com.example.demo.Security.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource("application.properties")
public class JwtUtil {


//    @Value("${jwt.secret}")
    private String SECRET_KET="THIS_IS_OUT_SECRET_KEY_FOR_THE_TOKEN";
    private static Authentication authentication = null;

    public String generateToken(){
        authentication =  SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub",authentication.getName());
        claims.put("role",authentication.getAuthorities().toArray()[0].toString());
        claims.put("created", new Date());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KET)
                .compact();
    }



    public String getUserName(String token){
        try {
            Claims c = Jwts.parser()
                    .setSigningKey(SECRET_KET)
                    .parseClaimsJws(token)
                    .getBody();

            return c.getSubject();
        }catch (Exception x){
            return x.getMessage();
        }
    }


    public boolean isTokenExpired(String token){
        try {
            return
                    Jwts.parser()
                            .setSigningKey(SECRET_KET)
                            .parseClaimsJws(token)
                            .getBody()
                            .getExpiration()
                            .before(new Date(System.currentTimeMillis()));
        }catch (Exception x){
            System.out.println("this is error " +x.getMessage());
            return false;
        }
    }
}
