package com.bug.terminating.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LoopTaskF implements Runnable{
	
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	private final int DATASET_SIZE = 100000;

	@Override
	public void run() {
		
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("#### ["+ currentThreadName +"] <" + taskId + "> STARTING ####");
		
		for (int i = 1;; i++) {
			System.out.println("["+ currentThreadName +"] <" + taskId +"> TICK TICK - " + i);
			
			doComplexCalculation();
			
			//INTERRUPTING a thread, sets a flag inside the thread.
			if(Thread.interrupted()) {
				System.out.println("#### ["+ currentThreadName +"] <" + taskId + "> Interrupted. Cancelling ####");
				break;
			}
			
		}
		
		//If you inquired the thread about it interrupted status again, the thread will return false.
		System.out.println("#### ["+ currentThreadName +"] <" + taskId + "> Retrieving 'INTERRUPTED' status again: ####" + Thread.interrupted());
		
		System.out.println("#### ["+ currentThreadName +"] <" + taskId + "> COMPLETED ####");
	}
	
	private void doComplexCalculation() {
		for (int i = 0; i < 2 ; i++) {
			Collections.sort(generatedDataSet());
		}
	}
	
	private List<Integer> generatedDataSet(){
		List<Integer> intList = new ArrayList<>();
		Random randomGenerator = new Random();
		
		for(int i = 0; i < DATASET_SIZE; i++) {
			intList.add(randomGenerator.nextInt(DATASET_SIZE));
		}
		
		return intList;
	}
	
	
	public LoopTaskF() {
		this.instanceNumber = ++count;
		this.taskId = this.getClass().getSimpleName() + "-" + instanceNumber;
	}
}
