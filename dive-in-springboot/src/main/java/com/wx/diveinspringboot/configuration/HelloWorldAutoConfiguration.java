package com.wx.diveinspringboot.configuration;

import com.wx.diveinspringboot.annotation.ConditionalOnSystemProperty;
import com.wx.diveinspringboot.annotation.EnableHelloworld;
import org.springframework.context.annotation.Configuration;

/**
 * @program: deep-in-springboot
 * @description: 自动装配类
 * @author: Mr.Wang
 * @create: 2021-05-15 17:08
 **/

@Configuration
@EnableHelloworld
@ConditionalOnSystemProperty(name = "user.name", value = "wx")
public class HelloWorldAutoConfiguration {
}
