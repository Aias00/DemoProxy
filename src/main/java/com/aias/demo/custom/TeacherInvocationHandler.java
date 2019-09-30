package com.aias.demo.custom;

import java.lang.reflect.Method;

public class TeacherInvocationHandler implements CustomInvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("需要被代理的类:" + clazz);
        return CustomPorxy.newProxyInstance(new CustomClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被代理前");
        System.out.println("------------");
        method.invoke(this.target, args);
        System.out.println("------------");
        System.out.println("代理之后");
        return null;
    }
}
