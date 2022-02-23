package com.wx.oauth2demo.controller;

import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-21 14:38
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        String token;
        if(header!=null){
            token = header.substring(header.indexOf("bearer") + 7);
        }else {
            token = request.getParameter("access_token");
        }

        return Jwts.parser().setSigningKey("123123".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token).getBody();
    }
}