package com.bug.naming.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorThread {

	public static void main(String[] args) {
		
		System.out.println("["+ Thread.currentThread().getName() + "] Main Cached Thread Pool starts here ..");
		
		//Initialization phase
		ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());
		
		for(int i = 0; i < 3; i++) {
			//Service phase
			executorService.execute(new LoopTaskC());
		}
		
		//Destruction phase
		executorService.shutdown();
		
		System.out.println("["+ Thread.currentThread().getName() + "] Main Cached Thread Pool ends here ..");
	}
}
