package com.bug.terminating.thread;

import java.util.concurrent.TimeUnit;

public class LoopTaskE implements Runnable{
	
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	/**
	 * Making it volatile tells the JVM to not do certain optimizations while compiling the code, as those
	 * optimizations sometimes results in the threads, not getting updated values of shared data.
	 * Hence, this will ensure that the threads always get the most recently updated value of this variable
	 * and not a stale value.
	 */
	private volatile boolean shutdown = false;

	@Override
	public void run() {
		
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("#### ["+ currentThreadName +"] <" + taskId + "> STARTING ####");
		
		for (int i = 1;; i++) {
			System.out.println("["+ currentThreadName +"] <" + taskId +"> TICK TICK - " + i);
			
			try {
				TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 3000));
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (this) {
				if(shutdown)
					break;
			}
		}
		
		System.out.println("#### ["+ currentThreadName +"] <" + taskId + "> COMPLETED ####");
	}
	
	public void cancel() {
		System.out.println("#### ["+ Thread.currentThread().getName() +"] <" + taskId + "> Shutting down ####");
		synchronized (this) {
			this.shutdown = true;
		}
	}
	
	public LoopTaskE() {
		this.instanceNumber = ++count;
		this.taskId = this.getClass().getSimpleName() + "-" + instanceNumber;
	}
}
