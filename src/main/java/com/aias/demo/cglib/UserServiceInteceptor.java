package com.aias.demo.cglib;


import com.aias.demo.User;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceInteceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入代理方法------");
        if (objects != null && objects.length > 0 && objects[0] instanceof User) {
            User user = (User) objects[0];
            if (user.getName().trim().length() <= 1) {
                throw new RuntimeException("用户名长度不能小于1");
            }
        }
        Object res = methodProxy.invokeSuper(o, objects);
        return res;
    }
}
