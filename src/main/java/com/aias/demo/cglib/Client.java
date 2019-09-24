package com.aias.demo.cglib;


import com.aias.demo.User;
import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        User user = new User();

        user.setAddress("shanghai");
        user.setName("as");
        user.setAge(12);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new UserServiceInteceptor());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.addUser(user);
        System.out.println(userService.hashCode());

    }
}
