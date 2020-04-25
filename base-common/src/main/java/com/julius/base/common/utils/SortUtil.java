package com.julius.base.common.utils;

import javassist.compiler.ast.StringL;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Package: com.julius.base.common.utils
 * @ClassName: SortUtil
 * @Author: Julius
 * @Description: 排序工具类
 * <tr>涉及到排序算法</tr>
 * <tr>普通的数字排序</tr>
 * <tr>数值数组排序</tr>
 * <tr>字符数组排序</tr>
 * <tr>集合排序</tr>
 * @Date: 2020/4/8 11:11
 * @Version: 1.0
 */
public class SortUtil {


    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge("1");
        User user1 = new User();
        user1.setAge("2");
        User user2 = new User();
        user2.setAge("11");
        User user3 = new User();
        user3.setAge("9");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        System.out.println("排序前："+list);

        //倒序排序使用reversed()  此方法不适合字符类型数字排序
//        Collections.sort(list, Comparator.comparing(User::getAge).reversed());
//        System.out.println("排序后1："+list);

//        重写compare
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Assert.notNull(o1,"first object must not be null");
                Assert.notNull(o2,"second object must not be null");
                Assert.notNull(o1.getAge(),"compare key must not be null");
                Assert.notNull(o2.getAge(),"compare key must not be null");

                //todo 正则校验字符

                return Integer.valueOf(o2.getAge())-Integer.valueOf(o1.getAge());
            }
        });

        //创建自定义比较器
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("11");
        stringList.add("9");
        stringList.add("2");
        System.out.println("排序后2："+list);
    }

}
