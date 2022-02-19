package com.wx.diveinspringboot.processor;

import com.wx.diveinspringboot.mapper.OrderMapper;
import com.wx.diveinspringboot.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import sun.reflect.generics.visitor.Reifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-04 16:50
 **/
public class LubanBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        String path = "com.wx.diveinspringboot.mapper";

        TuLinScanner scanner = new TuLinScanner(registry);
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return  true;
            }
        });
        scanner.doScan(path);



//        ArrayList<Class> list = new ArrayList<>();
//
//        list.add(UserMapper.class);
//        list.add(OrderMapper.class);
//
//        for (Class mapper: list) {
//            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
//            AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//            beanDefinition.setBeanClass(LuBanFactoryBean.class);
//            //给构造器传参
//            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);
//            registry.registerBeanDefinition(mapper.getSimpleName(),beanDefinition);
//        }
    }
}
