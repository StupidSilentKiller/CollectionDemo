package com.rossetta;

public class Test {
	public static void main(String[] args) throws Exception {
		final Counter c = new Counter();
		Threadd t1 = new Thread(new Runnable() {
			public void run() {
				for (int i=0; i < 1000; i++) {
					c.getCounter();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i=0; i<1000; i++) {
					c.getCounter();
				}
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(c.count);
	}
}

class Counter {
	int count = 0;
	
	public synchronized void getCounter() {
		count++;
	}
}
