package com.itheima;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testGetAge() {
        UserService userService = new UserService();
        int age = userService.getAge("44030419900101001X");
        System.out.println(age);
    }
}
