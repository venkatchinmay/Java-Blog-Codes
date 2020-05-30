package com.corejava.programs.circularlinkedlist;

import com.corejava.List.List;


public class CircularLinkedList<T> implements List<T>{
	
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
		Node<T> newNode = new Node<>(value,null);
		if(position <=0 || position > size+1) {
			throw new Exception("Invalid Size");
		}
		if(head == null) {
			head = newNode;
			tail = newNode;
			head.next = newNode;
			size++;
		}else if(position == size+1) {
			Node<T> temp = tail;
		    newNode.next = head;
		    temp.next = newNode;
		    tail = newNode;
		    size++;
		}else if (position == 1) {
			newNode.next = head;
			head = newNode;
			// below statements are important
			tail.next = head;
			size++;
		}else {
			int count = 1;
			for(Node<T> current = head; count< position ; current = current.next) {
				if(count == (position-1)) {
					Node<T> tmp = current.next;
					current.next = newNode;
					newNode.next = tmp;
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
		}while((temp != head));
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

}
