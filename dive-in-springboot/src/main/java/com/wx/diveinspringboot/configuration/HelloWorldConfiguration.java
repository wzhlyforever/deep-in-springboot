package com.wx.diveinspringboot.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-14 22:43
 **/

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloworld(){      //方法名就是bean名称
        return "hello world! 2021";
    }
}
