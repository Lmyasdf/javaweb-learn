package com.itheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testGetAge() {
        UserService userService = new UserService();
        int age = userService.getAge("44030419900101001X");
        System.out.println(age);
    }

    @Test
    public void testGetGender(){
        UserService userService = new UserService();
        String gender = userService.getGender("44030419900101001X");
        System.out.println(gender);
        //断言来判断测试方法是否按照预期效果执行
        Assertions.assertEquals("男", gender);
    }
}
