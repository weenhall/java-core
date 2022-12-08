package com.ween.thread.local;

/**
 * @author weenhall
 */
public class ThreadLocalUserContext implements Runnable{



	private static final ThreadLocal<Integer> userContext= new ThreadLocal<>();
	private Integer userId;

	public ThreadLocalUserContext(Integer userId){
		this.userId=userId;
	}

	@Override
	public void run() {
		userContext.set(userId);
		System.out.println("传入线程userId:"+userId+"当前线程userId:"+userContext.get());
	}
}
