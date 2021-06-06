package com.wx.diveinspringboot.config;

import com.wx.diveinspringboot.processor.LubanBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-03 15:04
 **/
@Configuration
//@EnableAspectJAutoProxy
@ComponentScan("com.wx.diveinspringboot")
@Import(LubanBeanDefinitionRegistrar.class)
public class AppConfig {

}