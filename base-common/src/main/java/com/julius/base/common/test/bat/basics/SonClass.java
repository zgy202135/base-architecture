package com.julius.base.common.test.bat.basics;

/**
 * @Package: com.julius.base.common.test.bat.basics
 * @ClassName: SonClass
 * @Author: Julius
 * @Description: 子类
 * @Date: 2020/3/17 13:27
 * @Version: 1.0
 */

public class SonClass extends FatherClass {

    private String secoundName;

    private String password;


    @Override
    public String login() {
        return "son user login success";
    }

    public String logout(){
        return "son logout success";
    }

    public String getSecoundName() {
        return secoundName;
    }

    public void setSecoundName(String secoundName) {
        this.secoundName = secoundName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
