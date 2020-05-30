package com.corejava.programs.doublelinkedlist;

import com.corejava.List.List;


public class DoubleLinkedList<T> implements List<T>{
	
	Node<T> head ;
	Node<T> tail;
	int size;

	@Override
	public void add(T value) throws Exception {
		addAtPosition(value,size+1);
		
	}

	@Override
	public void addFirst(T value) throws Exception {
		addAtPosition(value,1);
		
	}

	@Override
	public void addLast(T value) throws Exception {
		addAtPosition(value,size+1);
		
	}

	@Override
	public void addAtPosition(T value, int position) throws Exception {
		Node<T> newNode = new Node<>(null,value,null);
		if(position <=0 || position > size+1) {
			throw new Exception("Invalid Size");
		}
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}else if(position == 1) {
			Node<T> temp = head;
			newNode.next = temp;
			temp.previous = newNode;
			head = newNode;
			size++;
		}else if(position == size+1) {
			Node<T> temp = tail;
			temp.next = newNode;
			newNode.previous = temp;
			tail = newNode;
			size++;
		}else {
			int count = 1;
			for(Node<T> temp = head; count < position; temp = temp.next) {
				if(count == (position-1)) {
					Node<T> currentNode = temp.next;
					newNode.next = currentNode;
					currentNode.previous =newNode;
					temp.next = newNode;
					newNode.previous = temp;
					size++;
				}
				count = count+1;
			}
		}
	}

	public void addfromLastPosition(T value, int position) throws Exception {
		Node<T> newNode = new Node<>(null,value,null);
		if(position <=0 || position > size+1) {
			throw new Exception("Invalid Size");
		}
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}else if(position == size+1) {
			Node<T> temp = tail;
			temp.next = newNode;
			newNode.previous = temp;
			tail = newNode;
			size++;
		}else {
			int count = 1;
			for(Node<T> temp = tail; count < position; temp = temp.previous) {
				if(count == (position-1)) {
					Node<T> currentNode = temp.previous;
					newNode.previous = currentNode;
					currentNode.next =newNode;
					temp.previous = newNode;
					newNode.next = temp;
					size++;
				}
				count = count+1;
			}
		}
	}
	
	
	
	@Override
	public String traversingList() throws Exception {
		if(head == null) {
			throw new Exception("There is no Linked List");
		}
		Node<T> temp = head;
		String output = "{";
		while(temp != null) {
			output = output.concat(String.valueOf(temp.value).concat(","));
			temp = temp.next;
		}
		output = output.substring(0, output.length()-1).concat("}");
		return output;
	}
	
	public String traversingListReverse() throws Exception {
		if(head == null) {
			throw new Exception("There is no Linked List");
		}
		Node<T> temp = tail;
		String output = "{";
		while(temp != null) {
			output = output.concat(String.valueOf(temp.value).concat(","));
			temp = temp.previous;
		}
		output = output.substring(0, output.length()-1).concat("}");
		return output;
	}

	@Override
	public int size() {
		int size = 0;
		if(head == null) {
			return 0;
		}
		for(Node<T> currentNode = head; currentNode != null; currentNode = currentNode.next) {
			size++;
		}
		return size;
	}

}
