package com.ween.thread.local;

import java.util.Random;

public class ThreadLocalTest {

	public static void main(String[] args) {
		ThreadLocalUserContext first=new ThreadLocalUserContext(new Random().nextInt());
		ThreadLocalUserContext second=new ThreadLocalUserContext(new Random().nextInt());
		new Thread(first).start();
		new Thread(second).start();
	}
}
