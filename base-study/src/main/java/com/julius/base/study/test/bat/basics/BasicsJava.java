package com.julius.base.study.test.bat.basics;


import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.julius.base.common.test.bat
 * @ClassName: BasicsJava
 * @Author: Julius
 * @Description: java基础知识点
 * @Date: 2020/3/17 9:22
 * @Version: 1.0
 * java中==和equals和hashCode的区别
 * int、char、long各占多少字节数
 * int与integer的区别
 * 谈谈对java多态的理解
 * String、StringBuffer、StringBuilder区别
 * 什么是内部类？内部类的作用
 * 抽象类和接口区别
 * 抽象类的意义
 * 抽象类与接口的应用场景
 * 抽象类是否可以没有方法和属性？
 * 接口的意义
 * 泛型中extends和super的区别
 * 父类的静态方法能否被子类重写
 * 进程和线程的区别
 * final，finally，finalize的区别
 * 序列化的方式
 * Serializable 和Parcelable 的区别
 * 静态属性和静态方法是否可以被继承？是否可以被重写？以及原因？
 * 静态内部类的设计意图
 * 成员内部类、静态内部类、局部内部类和匿名内部类的理解，以及项目中的应用
 * 谈谈对kotlin的理解
 * 闭包和局部内部类的区别
 * string 转换成 integer的方式及原理
 */
public class BasicsJava {


    /**
     * @Description 测试泛型中的Extends
     * 上界通配符  其类和子类
     * @param list
     */
    public void testExtends(List<? extends FatherClass> list){
        //此处其实是使用了多态的特性
        for(FatherClass fatherClass : list){
            System.out.println(fatherClass.login());
        }
    }

    /**
     * @Description 泛型中的super
     * 下界通配符 其类和父类
     * @param list
     */
    public void testSuper(List<? super SonClass> list){
        //此处取出元素只能取出为Object
        for(Object object : list){
            object.getClass();
        }

    }


    public static void main(String[] args) {
        BasicsJava basicsJava = new BasicsJava();
        List<SonClass> sonClasses = new ArrayList<>();
        sonClasses.add(new SonClass());
        basicsJava.testExtends(sonClasses);
        FatherClass fatherClass = new SonClass();
        System.out.println("---"+fatherClass.login());

        System.out.println(SonClass.staticLogin());



//        String a = "a";
//        String b = "b";
//        String c = "a";
//        System.out.println("a="+a+",b="+b+",c="+c);
//        boolean a1 = a==b;
//        boolean a2 = a==c;
//
//        boolean b1 = a.equals(b);
//        boolean b2 = a.equals(c);
//
//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(b1);
//        System.out.println(b2);
//
//        System.out.println("a:"+a.hashCode()+",b:"+b.hashCode()+",c:"+c.hashCode());
//
//
//        System.out.println("修改后");
//        b = "a";
//        c = "b";
//
//        System.out.println("a="+a+",b="+b+",c="+c);
//        boolean a11 = a==b;
//        boolean a21 = a==c;
//
//        boolean b11 = a.equals(b);
//        boolean b21 = a.equals(c);
//        System.out.println(a11);
//        System.out.println(a21);
//        System.out.println(b11);
//        System.out.println(b21);
//        String d = new String("a");
//        System.out.println(d==a);//false
//        System.out.println(a.equals(d));//true
//
//        System.out.println("a:"+a.hashCode()+",b:"+b.hashCode()+",c:"+c.hashCode()+",d:"+d.hashCode());
//        int i = 128;
//        Integer j = new Integer(128);
//        Integer k = new Integer(128);
//        System.out.println(i==j);//自动拆箱
//        System.out.println(k==j);
//
//        Integer l = 128;
//        Integer m = 128;
//
//        Integer n = 127;
//        Integer o = 127;
//
//        System.out.println(l==m);
//        System.out.println(n==o);
//
//        //多态之向上转型（默认）
//        FatherClass fatherClass = new SonClass();
//
//        System.out.println(fatherClass.login()+"------"+fatherClass.getPassword()+"-------"+fatherClass.getPassword());
//        StringBuilder stringBuilder = new StringBuilder();
//        StringBuffer stringBuffer = new StringBuffer();
    }
}
