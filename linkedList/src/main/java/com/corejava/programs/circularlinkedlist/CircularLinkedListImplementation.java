package com.corejava.programs.circularlinkedlist;

public class CircularLinkedListImplementation {
	
	public static  CircularLinkedList<Integer> get() throws Exception {
		CircularLinkedList<Integer> CircularLinkedList = new CircularLinkedList<>();
	      CircularLinkedList.add(1);
	      CircularLinkedList.add(2);
	      CircularLinkedList.add(3);
	      CircularLinkedList.add(4);
	      CircularLinkedList.add(5);
	      CircularLinkedList.addAtPosition(13, 2);
	      CircularLinkedList.addLast(10);
		return CircularLinkedList;
	}

	public static void main(String[] args) throws Exception {
      CircularLinkedList<Integer> CircularLinkedList = get();
		//CircularLinkedList<Integer> CircularLinkedList = new CircularLinkedList<>();
		CircularLinkedList.add(5);
		CircularLinkedList.addFirst(100);
      String st = CircularLinkedList.traversingList();
      System.out.println(CircularLinkedList.size());
      System.out.println(st);
	}

}
