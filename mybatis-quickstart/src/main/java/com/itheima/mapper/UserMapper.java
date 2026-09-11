package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象）
//并且会自动将该实现类对象存入IOC容器中，作为Bean对象

public interface UserMapper {
    @Select("select * from user")
    public List<User> findAll();

    //根据id删除用户
    //#{}表示占位符，用于接收方法参数中的id值
    //#{id}表示将方法参数中的id值替换为SQL语句中的占位符
    //@Delete("delete from user where id = #{id}")//预编译
    public Integer deleteById(Integer id);


    //insert
    @Insert("insert into user(id,username,password,name,age) values(#{id},#{username},#{password},#{name}, #{age})")
    public Integer insert(User user);

    //update
    @Update("update user set username = 'zhouyu',password = '123456' where id = #{id}")
    public void update(Integer id);

    //根据id查询用户
    @Select("select * from user where id = #{id}")
    public User findById(Integer id);

    //Param注解用于将方法参数中的值替换为SQL语句中的占位符
    @Select("select * from user where username = #{uname} and password = #{pwd}")
    public User findByUsername(@Param("pwd") String pwd,@Param("uname") String uname);
}
