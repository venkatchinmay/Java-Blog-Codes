package com.corejava.programs.circulardoublelinkedlist;

import java.util.Scanner;

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
		String position = "";
		int count = 1;
		Node<T> current = head;
		do {
			if(current.data == value) {
				position = position.concat(String.valueOf(count)).concat(",");
				position = position.trim();
			}
			current = current.next;
			count = count+1;
		}while(current != head);

		if(!position.isEmpty()) {
			position = position.substring(0,position.length()-1);
		}
		return position;
	}

	@Override
	public void removeByValue(T value) throws Exception {
		String position = positionOfElement(value);
		System.out.println("Position ::: "+position);
		if(!position.isEmpty()) {
			String [] positions = position.split(",");
			if(positions.length > 1) {
				Scanner input = new Scanner(System.in);	
				System.out.println("Given element is present in "+position+" positions");
				System.out.println("ENTER the Select position from above one , if you need to delete in all positions ENTER all");
				String inputValue = input.nextLine();
				if(!inputValue.isEmpty() && position.contains(inputValue)) {
					removeElementAtPosition(Integer.parseInt(inputValue));
				}else if(inputValue.equalsIgnoreCase("all")) {
					removeElementAtPosition(Integer.parseInt(positions[0]));
					for (int i= 1; i< positions.length;i++) {
						removeElementAtPosition(Integer.parseInt(positions[i])-i);
					}
				}else {
					throw new Exception("Invalid input");
				}
			}else {
				removeElementAtPosition(Integer.parseInt(positions[0]));
			}
		}else {
			throw new Exception("Value is Not there in the list");
		}	
	}

	@Override
	public void removeAll() {
		head = null;
		tail = null;
	}
	
	private void removeElementAtPosition(int position) throws Exception {
		if(position > size || position <= 0) {
			throw new Exception("Invalid Position");
		}
		if (head == null) {
			throw new Exception("List is Empty");
		}else if (position == 1) {
			Node<T> temp = head.next;
			temp.previous = tail;
			head = temp;
			tail.next = head;
			size--;
		}else if(position == size) {
			Node<T> temp = tail.previous;
			temp.next = head;
			tail = temp;
			head.previous = tail;
			size--;
		}else {
			int count = 1;
			for(Node<T> current = head; count < position ; current = current.next) {
				if(count == position-1) {
					Node<T> temp = current.next.next;
					temp.previous = current;
					current.next = temp;
					size --;
				}
				count = count+1;
			}
		}
	}
	
	public void removeElementAtReversePosition(int position) throws Exception {
		if(head == null) {
			throw new Exception("List is Empty");
		}else if (position == 1) {
			Node<T> temp = tail.previous;
			temp.next = head;
			tail = temp;
			head.previous = tail;
			size--;
		}else if (position == size) {
			Node<T> temp = head.next;
			temp.previous = tail;
			head = temp;
			tail.next = head;
			size --;
		}else {
			int count = 1;
			for(Node<T> current = tail; count < position ; current = current.previous) {
				if(count == position-1) {
					Node<T> temp = current.previous.previous;
					current.previous = temp;
					temp.next = current;
					size--;
				}
				count = count+1;
			}
		}
	}
	
}
