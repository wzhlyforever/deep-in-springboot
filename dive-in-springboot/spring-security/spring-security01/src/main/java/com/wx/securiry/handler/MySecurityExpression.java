package com.wx.securiry.handler;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @program: deep-in-springboot
 * @description: 判断登录用户是否具有访问url的权限  获取用户角色
 * @author: Mr.Wang
 * @create: 2022-02-20 18:37
 **/
public class MySecurityExpression implements MySecurityExpressionOperator{

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        final Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            String name = request.getParameter("name");

            final Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

            return authorities.contains(new SimpleGrantedAuthority(name));

        }

        return false;
    }
}
