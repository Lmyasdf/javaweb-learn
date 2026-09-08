package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> getLines() {
        //    记载并读取user.txt文件
        ArrayList<String> lines = new ArrayList<>();
        //String path = "E:\\WebLearn\\springboot-web-01\\src\\main\\resources\\user.txt";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        IoUtil.readLines(in, StandardCharsets.UTF_8, lines);
        return lines;
    }

}
