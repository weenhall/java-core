package com.ween.thread;
import java.util.concurrent.*;

public class FutureTaskTest implements Callable<String> {

    @Override
    public String call(){
        return "using FutureTask to implement Thread";
    }

    public static void main(String[] args) {
        String result="";
        //创建异步任务
        FutureTask<String> futureTask=new FutureTask<>(new FutureTaskTest());
        //使用Thread开启线程
//        new Thread(futureTask).start();
//        try{
//            String result=futureTask.get();
//            System.out.println("任务执行完毕，返回结果:"+result);
//        }catch (Exception e){
//            System.out.println("任务执行错误,"+e.getMessage());
//        }
        //使用ExecutorService开启线程
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);
        executorService.shutdown();
        try{
            result=futureTask.get();
            System.out.println("任务执行完毕，返回结果:"+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
