package com.corejava.programs.circulardoublelinkedlist;

import com.corejava.List.List;


public class CircularDoubleLinkedList<T> implements List<T> {

	Node<T> head;
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
		if(position <= 0 || position > (size+1)) {
			throw new Exception("In Valid position");
		}
		Node<T> newNode = new Node<>(null,value,null);
		if(head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
			newNode.previous = tail;
			size++;
		}else if(position == 1) {
			Node<T> temp = head;
			newNode.previous = temp.previous;
			temp.previous = newNode;
			newNode.next = temp;
			head = newNode;
			tail.next = head;
			size++;
		}else if(position == size+1) { 
			Node<T> temp = tail;
			temp.next = newNode;
			newNode.next = head;
			newNode.previous = temp;
			tail = newNode;
			head.previous = tail;
			size++;
		}else {
			int count = 1;
			for(Node<T> current= head; count < position ; current = current.next) {
				if(count == (position -1)) {
					Node<T> temp = current.next;
					current.next = newNode;
					newNode.previous = current;
					newNode.next = temp;
					temp.previous = newNode;
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
		do {
			output = output.concat(String.valueOf(temp.data).concat(","));
			temp = temp.next;
		}while(temp!= head);
		
		output = output.substring(0, output.length()-1).concat("}");
		return output;
	}

	@Override
	public int size() {
		int size = 0;
		if(head == null) {
			return 0;
		}
		Node<T> current = head;
		do {
			current = current.next;
			size++;
		}while(current != head);
		
		return size;
	}
	
	public void addfromLastPosition(T value, int position) throws Exception {
		Node<T> newNode = new Node<>(null,value,null);
		if(position <=0 || position > size+1) {
			throw new Exception("Invalid Size");
		}
		if(position == 1) { 
			Node<T> temp = tail;
			temp.next = newNode;
			newNode.next = head;
			newNode.previous = temp;
			tail = newNode;
			head.previous = tail;
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
	
	public String traversingListReverse() throws Exception {
		if(tail == null) {
			throw new Exception("There is no Linked List");
		}
		Node<T> temp = tail;
		String output = "{";
		do {
			output = output.concat(String.valueOf(temp.data).concat(","));
			temp = temp.previous;
		}while(temp!= tail);
		
		output = output.substring(0, output.length()-1).concat("}");
		return output;
	}

	@Override
	public String positionOfElement(T value) {
		return null;
	}

	@Override
	public void removeByValue(T value) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}
}
