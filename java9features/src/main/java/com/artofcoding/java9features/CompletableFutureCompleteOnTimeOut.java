package com.artofcoding.java9features;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureCompleteOnTimeOut {

	public static int factory() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 42;
	}
	public static void main(String[] args) {
		CompletableFuture.supplyAsync(CompletableFutureCompleteOnTimeOut::factory)
		.thenAccept(System.out::println);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         // java 9 
		CompletableFuture<Integer> future =  CompletableFuture.supplyAsync(CompletableFutureCompleteOnTimeOut::factory)
				;
		future.thenAccept(System.out::println);

		future.completeOnTimeout(-1, 2, TimeUnit.SECONDS);
		// process completes in 2 seconds it gives value , other wise it gives -1 and move on 

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Java 9 
		CompletableFuture.supplyAsync(CompletableFutureCompleteOnTimeOut::factory)
		.orTimeout(2, TimeUnit.SECONDS)
		.thenAccept(System.out::println);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Java 9 
		CompletableFuture<Integer> cp = CompletableFuture.supplyAsync(CompletableFutureCompleteOnTimeOut::factory);
		CompletableFuture<Integer> cp2 = cp.copy();	
	}

}
