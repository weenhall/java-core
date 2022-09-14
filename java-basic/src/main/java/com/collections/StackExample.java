package com.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        System.out.println("Empty stack : "+stack);

        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Pop operation : "+stack.pop());
        System.out.println("After Pop : "+stack);
        System.out.println("search Operation : "+stack.search("A"));

        //Array To Stack
        String [] arr={"A","B","C","D"};
        Stack<String> arrStack=new Stack<>();
        for (String str:arr){
            arrStack.push(str);
        }
        System.out.println(arrStack);
        //List to Stack
        List<String> list=new ArrayList<>();
        list.add("E");
        list.add("F");
        arrStack.addAll(list);
        System.out.println(arrStack);
        //Stack To List
        List<String> list1=new ArrayList<>();
        list1.addAll(stack);
        System.out.println(list1);
    }
}
