package com.codingworld.stacks;

import java.util.Iterator;

public class StackWithLimitedSizeWithArray<T> implements Stack<T> {

	int capacity = 10;
	int stackSize = 0;

	@SuppressWarnings("unchecked")
	T [] stack = (T[]) new Object[capacity];

	public void push(T element) throws Exception {
		if(stackSize > capacity) {
			throw new Exception("Stack OverFlow Error");
		}else {
			stack[stackSize] = element;
			stackSize++;
		}
	}

	public T peek() throws Exception  {
		if(stackSize <= 0) {
			throw new Exception("Stack is Empty");
		}
		int index = stackSize-1;
		return stack[index];	
	}

	public T pop() throws Exception {
		if(stackSize <= 0) {
			throw new Exception("Stack is Empty");
		}
		stackSize = stackSize-1;
		return stack[stackSize];
	}

	public int size() {
		return stackSize;
	}

	public int capacity() {
		return capacity;
	}

	public String printStackElements() {
		String s = "{";
		Iterator<T> iterator = new StackWithLimitedSizeWithArrayIterator();
		while(iterator.hasNext()) {
			s = s.concat(iterator.next().toString());
			s = s.concat(",");
		}
		if(s.length()> 1) {
			s = s.substring(0,s.length()-1);
		}
		s = s.concat("}");
		return s;
	}

	private class StackWithLimitedSizeWithArrayIterator implements Iterator<T> {

		private int size = stackSize;

		public boolean hasNext() {
			return size > 0;
		}

		public T next() {
			size = size-1;
			return stack[size];
		}

	}





}
