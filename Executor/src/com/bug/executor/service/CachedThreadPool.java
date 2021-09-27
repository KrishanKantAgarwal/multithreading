package com.bug.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		
		System.out.println("Main Cached Thread Pool starts here ..");
		
		//Initialization phase
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		/**
		 * We are creating three instance of TaskA here as defined in for loop.
		 * If we create more than 3 instance of TaskA, the cached thread pool will look if there is any thread which is available,
		 * If the thread is available it can be reused and if there is no any thread available new thread will be created.
		 * 
		 * To see the difference change 3 to 6 and see the output. 
		 * You will see all the thread will start first without asking the thread to wait in the queue.
		 * 
		 */
		for(int i = 0; i < 3; i++) {
			//Service phase
			executorService.execute(new TaskA());
		}
		
		//Destruction phase
		executorService.shutdown();
		
		System.out.println("Main Cached Thread Pool ends here ..");
	}
}
