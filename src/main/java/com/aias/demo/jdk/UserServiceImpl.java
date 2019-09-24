package com.aias.demo.jdk;


import com.aias.demo.User;

public class UserServiceImpl implements UserService {

    public void addUser(User user) {
        System.out.println("用户入库成功：" + user.toString());
    }
}
