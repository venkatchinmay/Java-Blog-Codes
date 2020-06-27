package com.codingworld.stacks;

import java.util.Iterator;

public class StackWithUnLimitedCapacityWithArray<T> implements Stack<T> {
	
	int capacity = 1;
	int stackSize = 0;
	
	@SuppressWarnings("unchecked")
	T [] stack = (T[]) new Object[capacity];
	
	

	public void push(T element) throws Exception {
		isCapacityIncreased();
		stack[stackSize] = element;
		stackSize = stackSize+1;
	}

	public T pop() throws Exception {
		if(stackSize <= 0) {
			throw new Exception("Stack is Empty");
		}
		isCapacityDecreased();
		stackSize = stackSize-1;
		return stack[stackSize];
	}

	public T peek() throws Exception {
		if(stackSize <= 0) {
			throw new Exception("Stack is Empty");
		}
		int position = stackSize-1;
		return stack[position];
	}

	public int size() {
		return stackSize;
	}

	public int capacity() {
		return capacity;
	}

	public String printStackElements() {
		String s = "{";
		Iterator<T> iterator = new StackwithUnLimitedCapacityWithArrayIterator();
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
	
	@SuppressWarnings("unchecked")
	private boolean isCapacityIncreased() {
		boolean capacityIncreased = false;
		if(stackSize == capacity) {
			capacityIncreased = true;
			//Increasing the twice Capacity
			capacity = 2 * capacity;
			//Copying the elements to temp with increased capacity
			T [] temp = (T[]) new Object[capacity];
			for(int i=0; i< stackSize;i++) {
				temp[i] = stack[i];
			}
			stack = temp;
		}
		return capacityIncreased;
	}
	
	@SuppressWarnings("unchecked")
	private boolean isCapacityDecreased() {
		boolean isCapacityReduced = false;
		if(stackSize == capacity/4) {
			isCapacityReduced = true;
			//Decreasing the capacity
			capacity = capacity/2 ;
			//Copying the elements to temp with decreased capacity
			T [] temp = (T[]) new Object[capacity];
			for(int i=0; i< stackSize;i++) {
				temp[i] = stack[i];
			}
			stack = temp;
		}
		return isCapacityReduced;
	}
	
	public StackwithUnLimitedCapacityWithArrayIterator getIterator() {
		return new StackwithUnLimitedCapacityWithArrayIterator();
	}
	public class StackwithUnLimitedCapacityWithArrayIterator implements Iterator<T> {
         int size = stackSize;
		
         public boolean hasNext() {
			return size > 0;
		}

		public T next() {
			size = size-1;
			return stack[size];
		}
	}

}
