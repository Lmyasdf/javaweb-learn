package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //当前测试类中的测试方法运行时，会启动springboot项目-IOC
class MybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> list = userMapper.findAll();
        for(User user : list){
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteById(){
        Integer rows = userMapper.deleteById(1);
        if(rows > 0){
            System.out.println("删除成功");
            System.out.println("删除的行数为：" + rows);
        }
    }

    @Test
    public void testInsert(){
        User user = new User(1001,"admin","123456","张三",18);
        Integer rows = userMapper.insert(user);
        if(rows > 0){
            System.out.println("插入成功");
            System.out.println("插入的行数为：" + rows);
        }
    }

    @Test
    public void testUpdate(){
        userMapper.update(1001);
        System.out.println("更新成功");
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(1001);
        System.out.println(user);
    }
}
