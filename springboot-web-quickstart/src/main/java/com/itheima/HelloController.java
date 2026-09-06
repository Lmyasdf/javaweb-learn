package com.itheima;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //表示当前类是一个请求处理类:用来接收和处理前端请求的类
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name,int age){
        System.out.println("name :"+ name);
        return "Hello" + name + "~" + age;
    }
}
