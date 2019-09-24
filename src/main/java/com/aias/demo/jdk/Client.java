package com.aias.demo.jdk;

import com.aias.demo.User;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        User user = new User();
        user.setName("zhangsan");
        user.setAddress("beijing");
        user.setAge(12);
        UserService userService = new UserServiceImpl();
        UserServiceInteceptor userServiceInteceptor = new UserServiceInteceptor(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), userServiceInteceptor);
        proxy.addUser(user);
        System.out.println(proxy.hashCode());
    }
}
