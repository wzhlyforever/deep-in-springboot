package com.wx.diveinspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-08-23 15:04
 **/
public class HelloWorldApplicationContextInitilizer<C extends ConfigurableApplicationContext> implements
        ApplicationContextInitializer<C> {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ConfigurableApplicationContext.id: " + applicationContext.getId());
    }
}
