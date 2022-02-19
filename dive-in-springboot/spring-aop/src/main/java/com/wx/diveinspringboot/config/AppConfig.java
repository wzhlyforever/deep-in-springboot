package com.wx.diveinspringboot.config;

import com.wx.diveinspringboot.entity.Fox;
import com.wx.diveinspringboot.processor.LubanBeanDefinitionRegistrar;
import com.wx.diveinspringboot.service.UserService;
import com.wx.diveinspringboot.service.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-03 15:04
 **/
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("com.wx.diveinspringboot")
@MapperScan("com.wx.diveinspringboot.mapper")
@Import(LubanBeanDefinitionRegistrar.class)
public class AppConfig {


    @Bean
    public SqlSessionFactory  sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis?characterEncoding=UTF8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("wx19930908");
        return dataSource;
    }


}