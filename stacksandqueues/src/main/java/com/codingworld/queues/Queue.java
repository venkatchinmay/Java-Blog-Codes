package com.codingworld.queues;

public interface Queue<T> {
	
	public void enqueue(T value);
	
	public void dequeue() throws Exception ;
	
	public int size();

}
