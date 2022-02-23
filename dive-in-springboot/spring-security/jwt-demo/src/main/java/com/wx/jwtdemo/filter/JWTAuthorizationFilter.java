package com.wx.jwtdemo.filter;

import com.wx.jwtdemo.utils.JwtTokenUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @program: deep-in-springboot
 * @description:  jwt 鉴权过滤器
 * @author: Mr.Wang
 * @create: 2022-02-22 18:46
 **/
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {


    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        final String header = request.getHeader(JwtTokenUtil.TOKEN_HEADER);

        if (header == null || header.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request,response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(header));     //去进行认证
        super.doFilterInternal(request, response, chain);

    }


    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader){
        String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        final String userName = JwtTokenUtil.getUserName(token);

        String role = JwtTokenUtil.getUserRole("role");

        String[] roles = StringUtils.strip(role, "[]").split(", ");

        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (String s:roles)
        {
            authorities.add(new SimpleGrantedAuthority(s));
        }
        if (userName != null)
        {
            return new UsernamePasswordAuthenticationToken(userName, null,authorities);
        }
        return null;



    }

}
