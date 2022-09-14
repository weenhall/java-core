package com.ween.thread.start;

public class ThreadDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new WithRunnable(), "t1");
        Thread t2 = new Thread(new WithRunnable(), "t2");
        t1.start();
        t2.start();
        System.out.println("通过实现Runnable接口的线程启动");
        Thread t3=new WithThread("t3");
        Thread t4=new WithThread("t4");
        System.out.println("通过继承Thread类的线程启动");
        t3.start();
        t4.start();
    }

}
