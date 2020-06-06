package com.corejava.programs.doublelinkedlist;

import java.util.Scanner;

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

	@Override
	public String positionOfElement(T value) {
		String position = "";
		Node<T> current = head;
		int count = 1;
		while(current != null) {
			if(current.value == value) {
				position = position.concat(String.valueOf(count).concat(","));
				position = position.trim();
			}
			current = current.next;
			count = count+1;
		}
		if(!position.isEmpty()) {
			position = position.substring(0, position.length()-1);
		}
		return position;
	}

	@Override
	public void removeByValue(T value) throws Exception {
		String position = positionOfElement(value);
		if(!position.isEmpty()) {
		String [] positions = position.split(",");
		if(positions.length > 1) {
			Scanner input = new Scanner(System.in);
			System.out.println("Given element is present in "+position+" positions");
			System.out.println("ENTER the Select position from above one , if you need to delete in all positions ENTER all");
			String inputValue = input.nextLine();
			if(!inputValue.isEmpty() && position.contains(inputValue)) {
				removeByPosition(Integer.valueOf(inputValue));
			}else if(inputValue.equalsIgnoreCase("all")) {
				removeByPosition(Integer.valueOf(positions[0]));
				for(int i = 1; i< positions.length;i++) {
					removeByPosition(Integer.valueOf(positions[i])-i);	
				}
			}
		}else {
			removeByPosition(Integer.valueOf(positions[0]));
		}
		}else {
			throw new  Exception("Value is Not there in the Double linked list");
		}
	}
	
	private void removeByPosition(int position) throws Exception {
		if(position > size) {
			throw new Exception("Invalid position");
		}
		if(head == null) {
			throw new Exception("Double Linked list is Empty");
		}else if(position == 1) {
			Node<T> temp = head.next;
			temp.previous = null;
			head = temp;
			size--;
		}else if(position == size) {
			Node<T> temp = tail.previous;
			temp.next = null;
			tail = temp;
			size--;
		}else {
			int count = 1;
			for(Node<T> current = head; count< position ; current = current.next) {
				if(count == position-1) {
					Node<T> temp = current.next.next;
					current.next = temp;
					temp.previous = current;
					size --;
				}
				count = count+1;
			}
		}
	}

	@Override
	public void removeAll() {
		head = null;
		tail = null;
		
	}
	
	public void removeByReversePosition(int position) throws Exception {
		if(position > size) {
			throw new Exception("Invalid position");
		}
		if(position ==1) {
			Node<T> temp = tail.previous;
			temp.next = null;
			tail = temp;
			size--;
		}else if(position == size) {
			Node<T> temp = head.next;
			temp.previous = null;
			head = temp;
			size --;
		}else {
			int count = 1;
			Node<T> current = tail;
			while(count < position) {
				if(count == position-1) {
					Node<T> temp = current.previous.previous;
					current.previous = temp;
					temp.next = current;
					size --;
				}
				current = current.previous;
				count = count+1;
			}
		}
	}

}
