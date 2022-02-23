package com.wx.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-22 13:28
 **/

@SpringBootTest
public class JwtDemoApplicationTest {

    public static final String SECRETKEY = "123123";


    @Test
    public void test () {

        JwtBuilder jwtBuilder = Jwts
                .builder()
                .setId("666")  // 声明的标识  {“jti”：“666”}
                .setSubject("fox")   // {"sub": "fox" }
                .setIssuedAt(new Date())    // {iat: date }
                .setExpiration(new Date(System.currentTimeMillis()+60*1000))
                .claim("roles","admin")
                .claim("logo","xxx.jpg")
                .signWith(SignatureAlgorithm.HS256,SECRETKEY);

        final String token = jwtBuilder.compact();
        System.out.println(token);

        //三部分的base64解密
        System.out.println("=========");
        String[] split = token.split("\\.");
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        //无法解密
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));

    }

    @Test
    public void testParseToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9."
                + "eyJqdGkiOiI2NjYiLCJzdWIiOiJmb3giLCJpYXQiOjE2NDU1MDg5MTIsImV4cCI6MTY0NTUwODk3Miwicm9sZXMiOiJhZG1pbiIsImxvZ28iOiJ4eHguanBnIn0."
                + "pjusordQ87sty9ptiEvLlapiMyIy29qWcLmmvoDCeuE";

        final Claims claims = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody();

        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("issuedAt:"+claims.getIssuedAt());

        DateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("签发时间:"+sf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sf.format(new Date()));

    }

}
