package com.wx.diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-15 19:00
 **/
//@SpringBootApplication
public class SpringApplicationBootStrap {

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class, args);
        Set<String> set = new HashSet<>();
        set.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(set);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println("bean: " + context.getBean(ApplicationConfiguration.class));
    }


    @SpringBootApplication
    public static class ApplicationConfiguration{

    }
}
