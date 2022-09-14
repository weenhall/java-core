package com.ween.synchronizers;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CyclicBarrier 循环屏障
 * 描述：相较于CountDownLatch，只能执行一次，CyclicBarrier解决了该问题
 * 场景
 * 乘坐城际班车时，一般都是坐满一车出发，后面的人坐下一辆车
 */
public class CyclicBarrierDemo {

    static class Passenger implements Runnable{
        private CyclicBarrier barrier;
        private String name;
        public Passenger(CyclicBarrier barrier,String name){
            super();
            this.barrier=barrier;
            this.name=name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000*(new Random().nextInt(8)));
                System.out.println(name+"上车");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("========坐满3个，发车==========");
            }
        });

        ExecutorService executor= Executors.newFixedThreadPool(3);
        for (int i = 0; i <99 ; ) {
            executor.submit(new Thread(new Passenger(barrier,++i+"号乘客")));
            executor.submit(new Thread(new Passenger(barrier,++i+"号乘客")));
            executor.submit(new Thread(new Passenger(barrier,++i+"号乘客")));
        }
        executor.shutdown();
    }
}
