package com.itheima;

import java.util.ArrayList;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        boolean res = list.add("aaa");

        String s = list.get(0);
        //集合中无法直接添加基本数据类型。

        list.add(0,"bbb");
        //修改用set，index ,E e
        list.set(0,"aad");
        for (int i = 0; i < list.size(); i++) {
            String s1 = list.get(i);
            System.out.println(s1);

        }
        System.out.println(list);





    }
}
