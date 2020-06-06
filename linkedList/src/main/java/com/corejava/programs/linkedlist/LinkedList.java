package com.corejava.programs.linkedlist;

import java.util.Scanner;

import com.corejava.List.List;

public class LinkedList<T> implements List<T> {

	Node<T> head = null;
	Node<T> tail = null;
	int size = 0;
	
	/**
	 * Continously add at last position 
	 */
	@Override
	public void add(T value) throws Exception {
		Node<T> node = new Node<>(value,null);
		insertingNode(size+1,node);
	}
	/**
	 * Add at Starting Position 
	 * TimeComplexity 0(1)
	 */
	@Override
	public void addFirst(T value) throws Exception {
		Node<T> node = new Node<>(value,null);
		insertingNode(1,node);
	}
	/**
	 * add at Last Position
	 * TimeComplexity 0(1)
	 */
	@Override
	public void addLast(T value) throws Exception {
		Node<T> node = new Node<>(value,null);
		insertingNode(size+1,node);
	}
	/**
	 *  add at any position
	 *  TimeComplexity 0(n) 
	 */
	@Override
	public void addAtPosition(T value,int position) throws Exception {
		Node<T> node = new Node<>(value,null);
		insertingNode(position,node);
	}
	/**
	 * 
	 * @param position
	 * @param node
	 * @throws Exception
	 *
	 * Inserting at beginning 
	 * 
	 * New Node --> NewNode next = head and head = NewNode
	 * 
	 * Inserting at the End 
	 * 
	 * New Node ---> NewNode next = null and tail.next = NewNode and tail = NewNode
	 *  
	 * Inserting at particular position 
	 * 
	 * if you need to insert at position 2  then stop at position 1 and then apply logic 
	 * to avoid confusion index starting from 1 
	 * 
	 */
	private void insertingNode(int position,Node<T> node) throws Exception {
		if(position > size+1 || position <= 0) {
			throw new Exception("Invalid Size");
		}
		int firstPosition = 1;
		int lastPosition = size+1;
		if(head == null) {
		   head = node;
		   tail = node;
		   size++;
		}else if(firstPosition == position){
			node.next = head;
			head = node;
			size++;
		}else if(lastPosition == position) {
			node.next = null;
			tail.next = node; 
			tail = node;
			size++;
		}else {
			Node<T> tmp = head;
			int t = 1;
			while(tmp != null && t <= position-1) {
				if(t == position-1) {
					Node<T> nextNode = tmp.next;
					tmp.next = node;
					node.next = nextNode;
					size++;
				}
				tmp = tmp.next;
				t++;
			}
		}
	}
	/**
	 * Traversing the Linked List 
	 * 
	 * tmp = head ; 
	 * until tmp = null , tmp = tmp.next
	 * 
	 * 
	 * TimeComplexity 0(n)
	 * 
	 */
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
	/**
	 * Size of the Linked List 
	 */
	@Override
	public int size() {
		int linkedListsize = 0;
		if(head == null) {
			return 0;
		}
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next) {
			linkedListsize = linkedListsize+1;
		}
		return linkedListsize;
	}
	
	private void removeByPosition(int position) throws Exception {
		if(position > size) {
			throw new Exception("Invalid position");
		}
		if(head == null) {
			throw new Exception("List is Empty");
		}else if(position == 1) {
			head = head.next;
			size--;
		}else if(position == size) {
			for(Node<T> current = head; current != null; current = current.next) {
				if(current.next.next == null) {
					current.next = null;
					tail = current;
					size--;
				}
			}
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
	@Override
	public String positionOfElement(T value) {
		int count = 1;
		String position = "";
		Node<T> current = head;
		while(current != null) {
			if(value == current.value) {
				position = position.concat(String.valueOf(count)).concat(",");
				position = position.trim();
			}
			current = current.next;
			count = count+1;
		}
		if(!position.isEmpty()) {
			position = position.substring(0, position.length() - 1);
		}
		return position;
	}
	@Override
	public void removeByValue(T value) throws Exception {
		String position = positionOfElement(value);
		if(position.isEmpty()) {
			throw new Exception("Value is not there in the list");
		}else {
			Scanner input = new Scanner(System.in);
				String[] positions = position.split(",");
				if(positions.length > 1) {
					System.out.println("Given element is present in "+position+" positions");
					System.out.println("ENTER the Select position from above one , if you need to delete in all positions ENTER all");
					String inputValue = input.nextLine();
					if(!inputValue.isEmpty() && position.contains(inputValue)) {
						removeByPosition(Integer.valueOf(inputValue));
					}else if(inputValue.equalsIgnoreCase("All")) {
						removeByPosition(Integer.valueOf(positions[0]));
						for(int i=1; i< positions.length;i++) {
							removeByPosition(Integer.valueOf(positions[i])-i);
						}
					}else {
						throw new Exception("Your Input is Invalid .....");
					}
				}else {
					removeByPosition(Integer.valueOf(positions[0]));
				}
			}
		}
	@Override
	public void removeAll() {
		head = null;
		tail = null;
	}
	

	
	
}
