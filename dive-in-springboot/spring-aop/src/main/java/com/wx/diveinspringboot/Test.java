package com.wx.diveinspringboot;

import com.wx.diveinspringboot.config.AppConfig;
import com.wx.diveinspringboot.entity.Cat;
import com.wx.diveinspringboot.entity.Fox;
import com.wx.diveinspringboot.entity.User;
import com.wx.diveinspringboot.mapper.UserMapper;
import com.wx.diveinspringboot.service.UserService;
import com.wx.diveinspringboot.service.UserServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
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
        UserMapper userMapper = context.getBean(UserMapper.class);
        final User user = userMapper.selectById(1);
        System.out.println(user);


        //编程式
//        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition1.setBeanClass(User.class);
//        context.registerBeanDefinition("user", beanDefinition1);
//        context.getBean(User.class);
//
//        final DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
//        BeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
//        beanFactory.registerBeanDefinition("cat", beanDefinition);
//
//        context.getBean(Cat.class);

    }
}