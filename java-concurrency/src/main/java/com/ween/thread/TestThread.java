package com.ween.thread;

/**
 * @author weenhall
 */
public class TestThread {
    public static void main(String[] args) {
//        testByExtends();
        testByRunnable();
        Thread thread=new Thread(new ThreadSleep());
        thread.start();
    }

    private static void testByExtends() {
        WicketThread wicketThread = new WicketThread();
        Thread thread1 = new Thread(wicketThread, "001");
        Thread thread2 = new Thread(wicketThread, "002");
        Thread thread3 = new Thread(wicketThread, "003");
        Thread thread4 = new Thread(wicketThread, "004");
        Thread thread5 = new Thread(wicketThread, "005");
        Thread thread6 = new Thread(wicketThread, "006");
        Thread thread7 = new Thread(wicketThread, "007");
        Thread thread8 = new Thread(wicketThread, "008");
        Thread thread9 = new Thread(wicketThread, "009");
        Thread thread10 = new Thread(wicketThread, "010");
        Thread thread11 = new Thread(wicketThread, "011");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
    }

    private static void testByRunnable() {
        WicketRunnable runnable = new WicketRunnable();
        Thread thread1 = new Thread(runnable, "001");
        Thread thread2 = new Thread(runnable, "002");
        Thread thread3 = new Thread(runnable, "003");
        Thread thread4 = new Thread(runnable, "004");
        Thread thread5 = new Thread(runnable, "005");
        Thread thread6 = new Thread(runnable, "006");
        Thread thread7 = new Thread(runnable, "007");
        Thread thread8 = new Thread(runnable, "008");
        Thread thread9 = new Thread(runnable, "009");
        Thread thread10 = new Thread(runnable, "010");
        Thread thread11 = new Thread(runnable, "011");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
    }
}
