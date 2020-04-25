package com.julius.base.common.utils;

/**
 * @Package: com.julius.base.common.utils
 * @ClassName: User
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/4/8 11:21
 * @Version: 1.0
 */
public class User{
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                '}';
    }
}
