package com.wx.diveinspringboot.bootstrap;

import com.wx.diveinspringboot.annotation.EnableHelloworld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-14 22:46
 **/
@EnableHelloworld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloworld = context.getBean("helloworld", String.class);
        System.out.println("hello world bean: " + helloworld);
        context.close();
    }
}
