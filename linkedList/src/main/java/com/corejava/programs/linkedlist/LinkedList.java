package com.corejava.programs.linkedlist;

import com.corejava.List.List;

public class LinkedList<T> implements List<T> {

	Node<T> head = null;
	Node<T> tail = null;
	int size = 0;
	
	/**
	 * Continously add at last position 
	 */
	public void add(T value) throws Exception {
		Node<T> node = new Node<>(value,null);
		insertingNode(size+1,node);
	}
	/**
	 * Add at Starting Position 
	 * TimeComplexity 0(1)
	 */
	public void addFirst(T value) throws Exception {
		Node<T> node = new Node<>(value,null);
		insertingNode(1,node);
	}
	/**
	 * add at Last Position
	 * TimeComplexity 0(1)
	 */
	public void addLast(T value) throws Exception {
		Node<T> node = new Node<>(value,null);
		insertingNode(size+1,node);
	}
	/**
	 *  add at any position
	 *  TimeComplexity 0(n) 
	 */
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
		if(position > size+1 && position < 0) {
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
	public int size() {
		int linkedListsize = 1;
		if(head == null) {
			return 0;
		}
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next) {
			System.out.println(linkedListsize);
			System.out.println("----------------------");
			System.out.println(tmp.value);
			System.out.println("========================");
			linkedListsize = linkedListsize+1;
		}
		return linkedListsize;
	}
	

	
	
}
