package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController //内部包含一个ResponseBody注解,将方法返回值转换为json字符串
public class UserController {
    @RequestMapping("/list")
    @ResponseBody
    public List<User> list() throws Exception {
    //    记载并读取user.txt文件
        ArrayList<String> lines = new ArrayList<>();
        //String path = "E:\\WebLearn\\springboot-web-01\\src\\main\\resources\\user.txt";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        IoUtil.readLines(in, StandardCharsets.UTF_8, lines);

        //解析用户信息，封装为User对象 -> list集合
        List<User> userList = lines.stream().map(line ->{
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
