package com.collections.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(10, "10");
        map.put(9, "9");
        map.put(11, "11");
        System.out.println(map);

        //倒序
        map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 > o2) ? -1 : ((o1 == o2) ? 0 : 1);
            }
        });
        map.put(3, "3");
        map.put(1, "1");
        map.put(2, "2");
        System.out.println(map);

        usTreeMap();
    }

    //when to us treeMap
    public static void usTreeMap(){
        TreeMap<Integer,String> map=new TreeMap<>();
        for (int i = 0; i <10 ; i++) {
            map.put(i,"value-"+i);
        }
        System.out.println(map);

        //find id closest to 5,lower and higher
        Map.Entry<Integer,String> entry=map.lowerEntry(5);
        System.out.println("Closest lower key than 5 is "+entry.getKey());
        entry=map.higherEntry(5);
        System.out.println("Closest higher key than 5 is "+entry.getKey());
    }
}
