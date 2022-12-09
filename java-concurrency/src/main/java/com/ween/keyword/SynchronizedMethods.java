package com.ween.keyword;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedMethods {

	private int sum=0;
	private static int staticSum=0;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	//not safe
	public void calculate(){
		setSum(getSum()+1);
	}

	//using synchronized keyword
	public synchronized void synchronizedCalculate(){
		setSum(getSum()+1);
	}

	//using static and synchronized keyword
	public static synchronized void syncStaticCalculate(){
		staticSum+=1;
	}

	//using synchronized blocks
	public void performSynchronizedTask(){
		synchronized (this){
			setSum(getSum()+1);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		//not safe
		ExecutorService service= Executors.newFixedThreadPool(3);
		SynchronizedMethods methods=new SynchronizedMethods();
		IntStream.range(0,1000)
				.forEach(count->service.submit(methods::calculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(methods.getSum());
		System.out.println(methods.getSum()==1000);
		//safe
		SynchronizedMethods methods1=new SynchronizedMethods();
		IntStream.range(0,1000)
				.forEach(count->service.submit(methods1::synchronizedCalculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(methods1.getSum());
		System.out.println(methods1.getSum()==1000);
		//safe with static
		IntStream.range(0,1000)
				.forEach(count->service.submit(SynchronizedMethods::syncStaticCalculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(staticSum);
		System.out.println(staticSum==1000);
		//safe with synchronized blocks
		SynchronizedMethods methods2=new SynchronizedMethods();
		IntStream.range(0,1000)
				.forEach(count->service.submit(methods2::performSynchronizedTask));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(methods2.getSum());
		System.out.println(methods2.getSum()==1000);
	}
}
