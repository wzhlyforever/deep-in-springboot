package com.wx.diveinspringboot.bootstrap;

import com.wx.diveinspringboot.annotation.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-15 15:31
 **/

public class ConditionalOnSystemPropertyBootstrap {



    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "wx")
    public String helloworld(){
        return "hello,world!";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                                                    .web(WebApplicationType.NONE)
                                                    .run(args);

        String helloworld = context.getBean("helloworld",String.class);

        System.out.println("helloworld bean: " + helloworld);

        context.close();
    }
}
