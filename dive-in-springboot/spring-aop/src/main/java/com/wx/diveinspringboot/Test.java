package com.wx.diveinspringboot;

import com.wx.diveinspringboot.config.AppConfig;
import com.wx.diveinspringboot.service.UserService;
import com.wx.diveinspringboot.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-03 15:05
 **/
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        userService.queryUser();
    }
}