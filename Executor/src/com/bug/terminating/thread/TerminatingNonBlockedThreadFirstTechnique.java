package com.bug.terminating.thread;

import java.util.concurrent.TimeUnit;

/**
 * We see that the three tasks executed in three threads, after letting them run for some time.
 * The main thread called the cancelled method on each of the three tasks in the sequence.
 * Task one, then task two.And lastly, task three.
 * 
 * But the tasks did not end in the same sequence in which their canceled method had been invoked.
 * As discussed in the beginning, this is normal because after the setting of the shutdown flag, 
 * each task may take different amounts of time to reach the place where the check for the shutdown flag is happening inside the own method.
 * 
 * After reaching the shutdown check, each task may also do some cleanup activities that may again take different amounts of time.
 * Although no cleanup activities are happening in our current scenario.
 * So there is no guarantee as to which task shuts down first and which one shuts down last.
 * 
 */


public class TerminatingNonBlockedThreadFirstTechnique {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("[" + Thread.currentThread().getName() + "] Main thread starts here ..");
		
		LoopTaskE task1 = new LoopTaskE();
		LoopTaskE task2 = new LoopTaskE();
		LoopTaskE task3 = new LoopTaskE();
		
		new Thread(task1, "MyThread-1").start();
		new Thread(task2, "MyThread-2").start();
		new Thread(task3, "MyThread-3").start();
		
		TimeUnit.MILLISECONDS.sleep(5000);
		
		task1.cancel();
		task2.cancel();
		task3.cancel();
		
		System.out.println("[" + Thread.currentThread().getName() + "] Main thread ends here ..");
	}
	
	
}
