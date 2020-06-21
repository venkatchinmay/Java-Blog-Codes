package com.codingworld.stacks;

public interface Stack<T> {
	
	public void push(T element) throws Exception;
	
	public T pop() throws Exception ;
	
	public T peek() throws Exception ;
	
	public int size();
	
	public int capacity() ;
	
	public String printStackElements();
	

}
