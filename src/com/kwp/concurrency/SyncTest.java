package com.kwp.concurrency;

public class SyncTest {

	public static void main(String[] args) {
		Stack stack = new Stack("stack1");
		Producer producer1 = new Producer(stack,"producer1");
		Consumer consumer1 = new Consumer(stack,"consumer1");
	}

}
