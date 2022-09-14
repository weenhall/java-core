package com.ween.thread;

/**
 * @author weenhall
 */
public class ThreadSleep implements Runnable {

    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(500);
                System.out.println("当前线程:"+Thread.currentThread().getName()+" "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
