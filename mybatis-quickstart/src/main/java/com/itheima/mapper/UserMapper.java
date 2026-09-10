package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象）
//并且会自动将该实现类对象存入IOC容器中，作为Bean对象

public interface UserMapper {
    @Select("select * from user")
    public List<User> findAll();
}
