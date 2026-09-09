package com.itheima;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcTest {

    @Test
    public void testJdbc() throws Exception{
        //1.注册驱动 (告诉程序使用的是mysql的驱动)
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库连接
            //3306后斜杠指定操作的是哪个数据库
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "java";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.获取SQL语句执行对象
        Statement sm =  conn.createStatement();

        //4.执行SQL语句
        int rows = sm.executeUpdate("update user set age = 25 where id = 1");
        System.out.println("影响的记录数为："+rows);

        ResultSet rs = sm.executeQuery("select * from user");
        while(rs.next()){
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("age"));
            System.out.println("-----------------");

        }


        //5.关闭资源
        rs.close();
        sm.close();
        conn.close();




    }
}
