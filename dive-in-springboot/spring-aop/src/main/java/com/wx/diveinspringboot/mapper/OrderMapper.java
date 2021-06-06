package com.wx.diveinspringboot.mapper;

import org.apache.ibatis.annotations.Select;

public interface OrderMapper {


    @Select(value = "select user")
    String selectById(Integer id);
}
