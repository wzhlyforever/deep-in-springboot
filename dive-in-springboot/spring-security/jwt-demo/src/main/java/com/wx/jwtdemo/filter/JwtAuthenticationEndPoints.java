package com.wx.jwtdemo.filter;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @program: deep-in-springboot
 * @description:   匿名用户访问资源时，无权限处理
 * @author: Mr.Wang
 * @create: 2022-02-22 16:09
 **/
public class JwtAuthenticationEndPoints implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/javascript;charset=utf-8");
        response.getWriter().print(JSON.toJSONString("未登录，没有访问权限"));
    }
}
