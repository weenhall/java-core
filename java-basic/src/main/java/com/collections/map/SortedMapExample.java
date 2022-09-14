package com.collections.map;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {

    public static void main(String[] args) {
        SortedMap<String,String> sortedMap=new TreeMap<>();
        sortedMap.put("3","C");
        sortedMap.put("1","A");
        sortedMap.put("2","B");
        sortedMap.keySet().forEach(key->{
            System.out.println(key+"->"+sortedMap.get(key));
        });
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
    }
}
