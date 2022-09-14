package com.ween.thread;

import java.util.Random;
import java.util.concurrent.*;

public class FutureComputeTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int a=new Random().nextInt(10);
        System.out.println("a:"+a);
        return a;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        Integer max=0;
        for (int i = 0; i < 10; i++) {
            FutureTask ft=new FutureTask(new FutureComputeTest());
            executorService.submit(ft);
            int result=(int)ft.get();
            if(result>max){
                max=result;
            }
        }
        executorService.shutdown();
        System.out.println(max);
    }
}
