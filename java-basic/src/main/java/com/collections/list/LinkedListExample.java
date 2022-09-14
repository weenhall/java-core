package com.collections.list;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList适合添加和删除元素，不适合频繁的查找元素
 */
public class LinkedListExample {

    public static void main(String[] args) {
        basicOperation();
        arrayToLinkedList();
        linkedListToArray();
        dequeOperation();
        linkedListToStream();
    }

    //基本操作
    public static void basicOperation(){
        List<String> names=new LinkedList<String>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);
        System.out.println(names.size());
    }

    //Array To LinkedList
    public static void arrayToLinkedList(){
        Integer [] nums={1,2,3,4,5};
        List<Integer> listOfInteger=new LinkedList<>();
        for(Integer n:nums){
            listOfInteger.add(n);
        }
        System.out.println(listOfInteger);
    }

    //LinkedList To Array
    public static void linkedListToArray(){
        List<Integer> listOfInteger=new LinkedList<>();
        listOfInteger.add(1);
        listOfInteger.add(2);
        listOfInteger.add(3);
        listOfInteger.add(4);
        listOfInteger.add(5);

        Integer [] nums=new Integer[listOfInteger.size()];
        nums=listOfInteger.toArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *双端队列Deque基础
     * 1.offer/add都是往队列中添加一个元素,如何队列满了offer返回false,而add抛出异常
     * 2.poll/remove都是用来删除队列的第一个元素,如果队列为空,poll返回null,而remove抛出异常
     * 3.peek/element都是用来查询队列的第一个元素,如何队列为空,peek返回null,而element抛出异常
     */
    public static void dequeOperation(){
        Deque<String> names=new LinkedList<String>();
        names.add("C");
        names.addFirst("B");
        names.addLast("D");
        names.addFirst("A");
        names.addLast("E");
        System.out.println(names);

        names.removeFirst();
        names.removeLast();
        System.out.println(names);
        System.out.println(names.pollFirst());
        System.out.println(names);
        System.out.println(names.peekFirst());
        System.out.println(names);
    }

    //JDK8 LinkedList To Stream
    public static void linkedListToStream(){
        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);

        list.stream().forEach(System.out::println);
    }
}
