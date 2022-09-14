package com.collections.map;

import com.sun.javaws.IconUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

    public static void main(String[] args) {
        basicOperation();
    }

    public static void basicOperation(){
        //put
        Map<String,String> map=new HashMap<String,String>();
        map.put("1","A");
        map.put("2","B");
        map.put("3","C");
        map.put("4",null);
        //get
        System.out.println("key = 3, value = "+map.get("3"));
        System.out.println("key = 5, default value = "+map.getOrDefault("5","E"));;
        //contains key or value
        System.out.println("is key 3 exist : "+map.containsKey("3"));
        System.out.println("is value D exist : "+map.containsValue("D"));
        //for-each entrySet
        Set<Map.Entry<String,String>> entrySet=map.entrySet();
        entrySet.forEach(System.out::println);
        //size
        System.out.println("Map's size : "+map.size());
        //putAll
        Map<String,String> map1=new HashMap<>();
        map1.put("5","E");
        map1.put("6","F");
        map.putAll(map1);
        System.out.println(map);
        //keySet
        Set<String> keySet=map.keySet();
        System.out.println("map keys : "+keySet);
        //values
        Collection<String> values=map.values();
        System.out.println("map values :"+values);
        //clear
        map.clear();
        System.out.println("map after clear : "+map);
        //put ifAbsent
        System.out.println(map1);
        map1.putIfAbsent("5","EE");
        System.out.println(map1);

        //forEach
        map1.forEach((k,v)-> System.out.println("key = "+k+" value = "+v));
    }

}
