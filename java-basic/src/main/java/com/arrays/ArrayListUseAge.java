package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weenhall
 */
public class ArrayListUseAge {

    public static void main(String[] args) {
        List<String> l1=new ArrayList<>();
        l1.add("a");
        l1.add("b");

        List<String> l2=new ArrayList<>();
        l2.add("c");
        l2.add("d");

        List<String> [] arrayOfList=new List[2];
        arrayOfList[0]=l1;
        arrayOfList[1]=l2;
    }
}
