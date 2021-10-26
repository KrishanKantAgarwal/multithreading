package com.bug.terminating.thread;

import java.util.concurrent.TimeUnit;

/**
 * 	Note that just interrupting a thread will not stop the thread unless and until you check for the interrupted
 * 	status explicitly and then act on it.
 * 
 * 	INTERRUPTING a thread, sets a flag inside the thread.
 * 	And once you have inquired the thread about its interrupted status, that flag is reset automatically.
 * 	If you inquired the thread about it interrupted status again, the thread will return false.
 * 
 *  I said, interrupt the threads and not interrupted the tasks.
 *  The interrupt functionality is built into the threading mechanism and is provided out of the box by the JVM.
 *  
 *  Anyways, we see that the tasks read, interrupt successfully and exited out of their loops after exiting
 *  their loops.
 *  They inquired about the interrupt status the second time for their individual threads and have got the
 *  value false. It is because, as I mentioned earlier, once they interrupt, status has been read by the task.
 *  It is automatically reset by the JVM.
 * 
 */

public class TerminatingNonBlockedThreadSecondTechnique {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("[" + Thread.currentThread().getName() + "] Main thread starts here ..");
		
		Thread t1 = new Thread(new LoopTaskF(), "MyThread-1");
		t1.start();

		Thread t2 = new Thread(new LoopTaskF(), "MyThread-2");
		t2.start();
		
		Thread t3 = new Thread(new LoopTaskF(), "MyThread-3");
		t3.start();
		
		TimeUnit.MILLISECONDS.sleep(3000);
		
		System.out.println("[" + Thread.currentThread().getName() + "] Interrupting " + t1.getName() + "...");
		t1.interrupt();

		System.out.println("[" + Thread.currentThread().getName() + "] Interrupting " + t2.getName() + "...");
		t2.interrupt();

		System.out.println("[" + Thread.currentThread().getName() + "] Interrupting " + t3.getName() + "...");
		t3.interrupt();
		
		System.out.println("[" + Thread.currentThread().getName() + "] Main thread ends here ..");
	}
	
	
}
