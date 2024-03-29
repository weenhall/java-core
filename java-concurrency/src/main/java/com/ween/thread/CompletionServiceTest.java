package com.ween.thread;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
public class CompletionServiceTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        List<Future<Integer>> futureList=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            futureList.add(completionService.submit(new FutureComputeTest()));
        }
        try {
            for (int i = 0; i < 50; i++) {
                Future<Integer> completed = completionService.take();
                System.out.printf("currentThreadId:%d ,taskResult:%d%n", Thread.currentThread().getId(), completed.get());
                if(completed.get()==5){
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        } finally {
            futureList.forEach(f-> f.cancel(true));
            executorService.shutdown();
        }
    }
}
