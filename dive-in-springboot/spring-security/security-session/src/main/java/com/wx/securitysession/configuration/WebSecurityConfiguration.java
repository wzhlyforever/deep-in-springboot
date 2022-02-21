package com.wx.securitysession.configuration;


import com.wx.securitysession.strategy.MySessionStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-20 13:18
 **/

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin();
        http.sessionManagement().invalidSessionUrl("/session/invalid")
                .maximumSessions(1)
                .expiredSessionStrategy(new MySessionStrategy());

        http.authorizeRequests()
                .antMatchers("/login","/session/invalid").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("fox")
                .password(bCryptPasswordEncoder().encode("123456")).authorities("admin,user");
    }



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();


    }


}
