package com.bug.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void main(String[] args) {
		
		System.out.println("Main Fixed Thread Pool starts here ..");
		
		//Initialization phase
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		/**
		 * We are creating three instance of TaskA here as defined in for loop.
		 * If we create more than 3 instance of TaskA, and as we can see that we have only defined fixedThreadPool of 3, then
		 * After completing the task of any one thread new thread will be created ..
		 * 
		 * To see the difference change 3 to 6 and see the output.
		 */
		for(int i = 0; i < 6; i++) {
			//Service phase
			executorService.execute(new TaskA());
		}
		
		//Destruction phase
		executorService.shutdown();
		
		/**
		 * We cannot assign new task to the executor service after shutdown, if we do so we will get an exception as:
		 * java.util.concurrent.RejectedExecutionException:
		 * 
		 * Uncomment below method to see the exceptions
		 */
		//executorService.execute(new TaskA());
		
		System.out.println("Main Fixed Thread Pool ends here ..");
	}
}
