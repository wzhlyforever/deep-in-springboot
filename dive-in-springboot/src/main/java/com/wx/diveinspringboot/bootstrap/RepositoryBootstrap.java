package com.wx.diveinspringboot.bootstrap;

import com.wx.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: deep-in-springboot
 * @description: 启动类
 * @author: Mr.Wang
 * @create: 2021-05-14 20:56
 **/
@ComponentScan(basePackages = "com.wx.diveinspringboot.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE).run(args);

        MyFirstLevelRepository repository = context.getBean("MyFirstLevelRepository", MyFirstLevelRepository.class);


        System.out.println("MyFirstLevelRepositor bean:" + repository);

        context.close();

    }
}
