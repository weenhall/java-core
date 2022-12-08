package com.ween.thread;

/**
 * @author weenhall
 */
public class TicketThread extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        String cName = Thread.currentThread().getName();
        synchronized (this) {
            if(ticket<=0){
                System.out.println("窗口:"+cName+"票已卖完");
            }else{
                ticket--;
                System.out.println("窗口:" + cName + "卖出一张票,当前剩余:" + ticket + "票");
            }
        }
    }
}
