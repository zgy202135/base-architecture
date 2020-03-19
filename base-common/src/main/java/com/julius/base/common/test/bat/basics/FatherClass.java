package com.julius.base.common.test.bat.basics;

/**
 * @Package: com.julius.base.common.test.bat.basics
 * @ClassName: FatherClass
 * @Author: Julius
 * @Description: 父类
 * @Date: 2020/3/17 13:16
 * @Version: 1.0
 */
public class FatherClass {
    private String userName;

    private String password;



    public String login(){
        return "login success";
    }

    public static String staticLogin(){
        return "static login success";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
