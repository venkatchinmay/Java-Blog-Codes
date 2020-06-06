package com.corejava.programs.circularlinkedlist;

import java.util.Scanner;

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
					removeElementByPosition(Integer.parseInt(inputValue));
				}else if(inputValue.equalsIgnoreCase("all")) {
					removeElementByPosition(Integer.parseInt(positions[0]));
					for (int i= 1; i< positions.length;i++) {
						removeElementByPosition(Integer.parseInt(positions[i])-i);
					}
				}else {
					throw new Exception("Invalid input");
				}
			}else {
				removeElementByPosition(Integer.parseInt(positions[0]));
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

	private void removeElementByPosition(int position) throws Exception {
		if(position > size) {
			throw new Exception("Invalid position");
		}

		if(head == null) {
			throw new Exception("List is Empty");
		} else if(position == 1) {
			Node<T> temp = head.next;
			head = temp;
			tail.next = head;
			size--;
		}else if(position == size) {
			Node<T> current = head;
			do {
				if(current.next.next == head) {
					current.next = head;
					tail = current;
					size --;
				}
				current = current.next;
			}while(current != head);
		}else {
			int count = 1;
			for(Node<T> current = head; count < position ; current = current.next) {
				if(count == position-1) {
					Node<T> temp = current.next.next;
					current.next = temp;
					size--;
				}
				count = count+1;
			}
		}
	}

}
