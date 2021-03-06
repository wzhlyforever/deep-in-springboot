package com.wx.diveinspringboot.processor;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-04 16:03
 **/

public class LuBanFactoryBean implements FactoryBean {


    private Class mapper;

    private SqlSession sqlSession;

    public LuBanFactoryBean(Class mapper) {
        this.mapper = mapper;
    }


    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory){
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {
        final Object o = Proxy.newProxyInstance(LuBanFactoryBean.class.getClassLoader(), new Class[]{mapper}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return mapper;
    }
}
