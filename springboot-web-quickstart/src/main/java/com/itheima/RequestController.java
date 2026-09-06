package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//获取请求数据的各个部分
@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式" + method);
        //2.获取请求url地址
        String url = request.getRequestURL().toString();
        System.out.println(url);
        //3.获取请求协议
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //4.获取请求参数
        String name = request.getParameter("name");
        System.out.println(name);
        //5.获取请求头
        String accept = request.getHeader("Accept");
        return "ok";
    }
}
