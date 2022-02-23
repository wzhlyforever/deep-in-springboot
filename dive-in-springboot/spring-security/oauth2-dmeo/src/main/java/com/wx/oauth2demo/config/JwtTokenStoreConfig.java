package com.wx.oauth2demo.config;

import com.wx.oauth2demo.enhancer.JwtTokenEnhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-22 14:33
 **/

@Configuration
public class JwtTokenStoreConfig {


    @Bean
    public JwtTokenStore jwtTokenStore(){

        return new JwtTokenStore(jwtAccessTokenConverter());

    }

    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer(){
        return new JwtTokenEnhancer();
    }


    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();

        accessTokenConverter.setSigningKey("123123");
        return accessTokenConverter;
    }


}
