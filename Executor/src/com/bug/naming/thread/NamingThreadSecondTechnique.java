package com.bug.naming.thread;

import java.util.concurrent.TimeUnit;

public class NamingThreadSecondTechnique {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("[" + Thread.currentThread().getName() + "] Main thread starts here ..");
		
		new Thread(new LoopTaskC(), "Worker-1").start();
		
		Thread t2 = new Thread(new LoopTaskC());
		t2.setName("Worker-2");
		t2.start();
		
		//Adding a delay to check the difference, when it picks the new thread name
		TimeUnit.MILLISECONDS.sleep(1000);
		
		/**
		 * We can also name the thread after starting, it
		 * If we are doing so then in Task we should always take the currentThreadName using Thread.currentThread.getName()
		 * 
		 * We should not initialize the threadName at one place and use it the way we have done in LoopTaskB class. 
		 * Always use Thread.currentThread.getName() everywhere we want to have the thread name.
		 * 
		 * Uncomment the below code to check the difference. In beginning the name of the thread will be Thread-N, 
		 * later it will pick the thread name which we will set below
		 */
		
		//t2.setName("Worker-2");
		
		
		System.out.println("[" + Thread.currentThread().getName() + "] Main thread ends here ..");
	}

}
