package com.wx.diveinspringboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: deep-in-springboot
 * @description: spring 应用事件引导类
 * @author: Mr.Wang
 * @create: 2021-05-16 18:13
 **/
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        //创建ioc容器
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();

        //注册应用事件监听器
        configApplicationContext.addApplicationListener(event -> {
            System.out.println("监听事件： " + event);
        });

        //启动上下文
        configApplicationContext.refresh();
        // 发布事件
        configApplicationContext.publishEvent("helloworld");


        configApplicationContext.close();

    }

}
