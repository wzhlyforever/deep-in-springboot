package com.wx.diveinspringboot.service;

import com.wx.diveinspringboot.mapper.OrderMapper;
import com.wx.diveinspringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-03 15:06
 **/

@Component
public class UserServiceImpl{


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public void queryUser() {
        System.out.println("userService");


        System.out.println(userMapper.selectById(1));
        System.out.println(orderMapper.selectById(2));
    }
}
