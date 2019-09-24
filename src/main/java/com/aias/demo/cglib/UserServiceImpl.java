package com.aias.demo.cglib;


import com.aias.demo.User;

public class UserServiceImpl {
    public final void addUser(User user) {
        System.out.println("用户信息入库成功:" + user.toString());
    }

}
