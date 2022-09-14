package com.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *   基本操作
 *   Operation     ThrowsException    SpecialValue
 *   insert          add()              offer()
 *   remove          remove()           poll()
 *   examine         element()          peek()
 *
 *   队列分类
 *   1.按是否有界
 *   BoundedQueues(有界队列,需指定大小)        UnboundedQueues(无界队列)
 *如 ArrayBlockQueue                         LinkedList
 *   2.按是否阻塞
 *   BlockingQueues(阻塞队列)     Non-BlockingQueues(非阻塞队列)
 *
 */
public class QueueExample {

    public static void main(String[] args) {
        basicOperation();
        arrayToQueue();
        queueToArray();
//        insertOperation();
//        deleteOperation();
        examineOperation();
    }

    public static void basicOperation() {
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        System.out.println(queue);

        queue.remove("D");
    }

    public static void arrayToQueue() {
        String[] letters = {"A", "B", "C", "D", "E"};
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, letters);
        System.out.println(queue);
    }

    public static void queueToArray() {
        Queue<String> queue=new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        String strArr[]=queue.toArray(new String[queue.size()]);
        System.out.println(Arrays.toString(strArr));
    }

    public static void insertOperation(){
        //using add()
        BlockingQueue<String> queue=new ArrayBlockingQueue<>(2);
//        System.out.println(queue.add("1"));
//        System.out.println(queue.add("2"));
//        System.out.println(queue);
//        System.out.println(queue.add("3"));
//        System.out.println(queue);
        //using offer()
        queue=new ArrayBlockingQueue<>(2);
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("2"));
        System.out.println(queue);
        System.out.println(queue.offer("3"));
        System.out.println(queue);
    }

    public static void deleteOperation(){
        Queue<String> queue=new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        //using remove()
//        System.out.println(queue);
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
        //using poll()
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

    public static void examineOperation(){
        Queue<String> queue=new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        //using element()
//        System.out.println(queue.element());
//        System.out.println(queue);
//        queue.clear();
//        System.out.println(queue.element());
        //using peek()
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.clear();
        System.out.println(queue.peek());
    }
}
