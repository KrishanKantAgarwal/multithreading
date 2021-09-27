package com.bug.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutors {

	public static void main(String[] args) {
			
		System.out.println("Main Single Thread Executor starts here ..");
		
		//Initialization phase
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		/**
		 * Only one thread will be start and after the completion of first thread only. 
		 * A new thread will be created and executed
		 */
		for(int i = 0; i < 3; i++) {
			//Service phase
			executorService.execute(new TaskA());
		}
		
		//Destruction phase
		executorService.shutdown();
		
		System.out.println("Main Single Thread Executor ends here ..");
	}

}
