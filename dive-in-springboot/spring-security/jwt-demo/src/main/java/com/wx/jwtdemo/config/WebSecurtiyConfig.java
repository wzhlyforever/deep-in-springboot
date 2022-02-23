package com.wx.jwtdemo.config;

import com.wx.jwtdemo.filter.JWTAuthenticatinFilter;
import com.wx.jwtdemo.filter.JWTAuthorizationFilter;
import com.wx.jwtdemo.filter.JwtAuthenticationEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-22 15:46
 **/
public class WebSecurtiyConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().and()
                .authorizeRequests().antMatchers("/user/**").hasRole("admin")
                .anyRequest().permitAll().and()
                .addFilter(new JWTAuthenticatinFilter(authenticationManager()))  // 添加登录过滤器
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))   // 添加鉴权过滤器
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEndPoints())
                .and().csrf().disable();

    }
}
