package com.wx.oauth2demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.redis.core.types.Expiration;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-22 16:59
 **/
public class JwtTokenUtil {



    public static final String ROLE_CLAIMS = "role";

    public static final long EXPIRATION = 24 * 60 * 60;

    public static final String SECRET_KEY = "123123";


    /**
     * @param userName
     * @param password
     * 创建token
     * @return
     */
    public static String createToken(String userName, String password){

        Map<String, Object> info = new HashMap<>();
        info.put("role",ROLE_CLAIMS);

        final String token = Jwts.builder()
                .setSubject(userName)
                .setClaims(info)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .claim("username", userName)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

        return token;

    }


    /**
     * @param token
     * 校验token
     * @return
     */
    public static Claims parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims;
    }


    /**
     * @param token  从token种获取usename
     *
     * @return
     */
    public static String getUserName(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        String username = claims.getSubject();

        return username;
    }

    /**
     * 从Token中获取用户角色
     */
    public static String getUserRole(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("role").toString();
    }

    /**
     * 校验Token是否过期
     */
    public static boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

}
