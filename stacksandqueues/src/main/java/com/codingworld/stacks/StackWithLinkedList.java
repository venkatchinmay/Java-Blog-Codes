package com.codingworld.stacks;

import java.util.Iterator;

/**
 * 
 *   peek <--|node-3|  <--- |node-2| <--| tail |
 */

public class StackWithLinkedList<T> implements Stack<T> {

	Node<T> tail;
	Node<T> currentHeadNode;
	int size;

	public void push(T element) throws Exception {
		Node<T> insertedNode = new Node<T>(element,null);
		if(tail == null) {
			tail = insertedNode;
			currentHeadNode = insertedNode;
			size++;
		}else {
			insertedNode.next = currentHeadNode;
			currentHeadNode = insertedNode;
			size++;
		}
	}

	public T pop() throws Exception {
		if(currentHeadNode == null) {
			throw new Exception("There is no elements in stack");
		}else {
			Node<T> previousNode = currentHeadNode;
			currentHeadNode = currentHeadNode.next;
			size--;
			return previousNode.value;
		}
	}

	public T peek() throws Exception {
		if(currentHeadNode == null) {
			throw new Exception("There is no elements in stack");
		}
		return currentHeadNode.value;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return size;
	}

	public String printStackElements() {
		String s = "{";
		Iterator<T> iterator = new StackWithLinkedListIteration();
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
	private class StackWithLinkedListIteration implements Iterator<T> {

		Node<T> current = currentHeadNode;

		public boolean hasNext() {
			return current!= null;
		}

		public T next() {
			Node<T> previousNode = current;
			current = current.next;
			return previousNode.value;
		}

	}



}
