package com.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        basicOperation();
    }

    //基本操作
    public static void basicOperation(){
        Set<String> fruits=new HashSet<String>();
        fruits.add("Apple");
        fruits.add("Banana");

        System.out.println("是否为空:"+fruits.isEmpty());
        System.out.println("是否包含Apple元素:"+fruits.contains("Apple"));

        System.out.println(fruits.remove("Apple"));
        System.out.println(fruits.remove("Mango"));

        //addAll
        List<String> list=new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        fruits.addAll(list);
        System.out.println(fruits);
    }

    //遍历，参考ArrayList
}
