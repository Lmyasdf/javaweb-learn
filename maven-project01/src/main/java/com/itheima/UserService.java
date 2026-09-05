package com.itheima;

public class UserService {
    public int getAge(String idCard) {
        int year = Integer.parseInt(idCard.substring(6, 10));
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }
}
