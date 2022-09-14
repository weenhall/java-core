package com.ween.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch 倒计时门栓
 * 描述:通过多线程协作执行多个子任务完成后再进行后面的代码
 * 场景
 * 商品拼团需要达到指定数量客户才能拼成功
 */
public class CountDownLatchDemo {
    private static final CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"加入拼团");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println("拼团成功，订单处理中...");
    }
}
