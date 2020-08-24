package com.codingworld.queues;

import java.util.Iterator;

public class QueueImplementation<T> implements Queue<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;

	@Override
	public void enqueue(T value) {
		Node<T> newNode = new Node<>(value,null);
		if(tail!= null) {
		  Node<T> temp = tail;
		  temp.nextNode = newNode;
		  tail = newNode;
		  tail.nextNode = null;
		  size++;
		}else {
			tail = newNode;
			head = newNode;
			size++;
		}
	}

	@Override
	public void dequeue() throws Exception {
         if(head != null) {
        	 Node<T> current = head.nextNode;
        	 head = current;
        	 size--;
         }else {
        	 throw new Exception("There is no elements in queue to remove");
         }
	}

	@Override
	public int size() {
		return size;
	}
	
	public String printElementsInaQueue() {
		String result = "{";
		Node<T> current = head;
		while(current != null) {
			result = result.concat(String.valueOf(current.value));
			result = result.concat(",");
			current = current.nextNode;
		}
		if(!result.equals("{")) {
			result = result.substring(0,result.length()-1);
		}
		result = result.concat("}");
		return result;
	}
	
	public class QueueIterator implements Iterator<T> {
		
		public Node<T> current = head;

		@Override
		public boolean hasNext() {
			return current!= null;
		}

		@Override
		public T next() {
			Node<T> temp = current;
			current = current.nextNode;
			return temp.value;
		}
		
	}

}
