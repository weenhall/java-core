package com.ween.synchronizers;

import java.util.concurrent.Semaphore;

/**
 * Semaphore信号量
 * 描述：用来控制多线程访问临界资源时的线程数
 * 场景：
 * 停车场车位有限，当停车位都被占用了，外面的车就不允许进入了，就必须在外面等着。出来一辆车才允许进去一辆车
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws Throwable{
        Semaphore semaphore=new Semaphore(10,false);
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+",进入停车场，占用一个停车位");
                    System.out.println(semaphore.hasQueuedThreads()?"暂时没有车位":"车位充足");
                    Thread.sleep(5000);//模拟停车时间
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+",离开停车场");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
