package com.bug.naming.thread;

import java.util.concurrent.ThreadFactory;

public class NamingThreadFactory implements ThreadFactory {

	private static int count = 0;
	private static String NAME = "PoolWorker-";
	
	@Override
	public Thread newThread(Runnable r) {
		//This Runnable r -> is generated internally by the JVM
		Thread t = new Thread(r, NAME +  ++count);
		return t;
	}

}
