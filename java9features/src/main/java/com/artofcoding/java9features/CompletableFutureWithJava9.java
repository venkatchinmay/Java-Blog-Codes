package com.artofcoding.java9features;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureWithJava9 {

	public static int factory() {
		try {
			//Method is taking 5 seconds to execute
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 42;
	}
	
	public static void  regularJava8() {
		System.out.println("Regular java 8 program");
		// java 8 
		CompletableFuture.supplyAsync(CompletableFutureWithJava9::factory)
		.thenAccept(System.out::println);

	}
	
	public static void completeOnTimeoutDemo() {
		System.out.println("completeOnTimeout ::: java 9 program");
		// java 9 
		// process completes in 2 seconds it gives value , other wise it gives -1 and move on 
		 CompletableFuture.supplyAsync(CompletableFutureWithJava9::factory)
		 .completeOnTimeout(-1, 2, TimeUnit.SECONDS)
		 .thenAccept(System.out::println);
	}
	public static void orTimeoutDemo() {
		System.out.println("orTimeout ::: java 9 program");
		// java 9 
		CompletableFuture.supplyAsync(CompletableFutureWithJava9::factory)
		.orTimeout(2, TimeUnit.SECONDS)
		.thenAccept(System.out::println);	
	}
	public static void copyDemo() {
		System.out.println("copy ::: java 9 program");
		// java 9 
		CompletableFuture<Integer> cp = CompletableFuture.supplyAsync(CompletableFutureWithJava9::factory);
		CompletableFuture<Integer> cp2 = cp.copy();	
		// Making mainThread Sleep 
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Original :::: "+cp.thenAccept(System.out::println));
		// Making mainThread Sleep 
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		System.out.println("Copy :::: "+cp2.thenAccept(System.out::println));
	}
	
	
	
	
	public static void main(String[] args) {
		regularJava8();
		// Making mainThread Sleep 
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		completeOnTimeoutDemo();
		
		// Making mainThread Sleep 
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Java 9 
		orTimeoutDemo();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Java 9 
		copyDemo();
	}

}
