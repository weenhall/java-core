package com.ween.thread.start;

public class WithThread  extends Thread{

    public WithThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("当前线程: "+Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
            System.out.println("业务处理中..."+Thread.currentThread().getName());
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("业务处理完毕: "+Thread.currentThread().getName());
    }
}
