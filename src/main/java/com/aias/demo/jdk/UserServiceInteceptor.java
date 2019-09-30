package com.aias.demo.jdk;


import com.aias.demo.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceInteceptor implements InvocationHandler {

    private Object realObj;

    public Object getRealObj() {
        return realObj;
    }

    public void setRealObj(Object realObj) {
        this.realObj = realObj;
    }

    public UserServiceInteceptor(Object realObj) {
        super();
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理方法------");
        if (args != null && args.length > 0 && args[0] instanceof User) {
            User user = (User) args[0];
            if (user.getName().trim().length() <= 1) {
                throw new RuntimeException("用户名长度不能小于1");
            }
        }
        Object res = method.invoke(realObj, args);
        return res;
    }
}
