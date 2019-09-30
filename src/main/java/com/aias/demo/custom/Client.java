package com.aias.demo.custom;

import com.aias.demo.jdk.UserService;

public class Client {
    public static void main(String[] args) {
        EnglishTeacher teacher = new EnglishTeacher();
        TeacherInvocationHandler userServiceInteceptor = new TeacherInvocationHandler();
        userServiceInteceptor.setTarget(teacher);
        Teacher proxy = (Teacher) CustomPorxy.newProxyInstance(new CustomClassLoader(), teacher.getClass().getInterfaces(), userServiceInteceptor);
        proxy.teach();
        System.out.println(proxy.hashCode());
    }
}
