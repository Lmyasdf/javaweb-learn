package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.itheima.pojo.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired//不能用在局部变量上
    private UserDao userDao;
    @Override
    public List<User> getUserList(){
        List<String> lines = userDao.getLines();
        List<User> userList = new ArrayList<>();
        //解析用户信息，封装为User对象 -> list集合
        userList = lines.stream().map(line ->{
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            Integer age = Integer.parseInt(parts[2]);
            String name = parts[3];
            String password = parts[4];
            String data = parts[5];
            return new User(id, username, age, name, password, data);
        }).toList();
        return userList;
    }
}
