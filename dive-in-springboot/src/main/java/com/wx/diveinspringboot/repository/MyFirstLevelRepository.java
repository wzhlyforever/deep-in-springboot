package com.wx.diveinspringboot.repository;

import com.wx.diveinspringboot.annotation.FirstLevelRepository;
import com.wx.diveinspringboot.annotation.SecondLevelRepository;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-14 20:52
 **/

//@FirstLevelRepository(value = "MyFirstLevelRepository")    // bean名称
@SecondLevelRepository(value = "MyFirstLevelRepository")
public class MyFirstLevelRepository {

}
