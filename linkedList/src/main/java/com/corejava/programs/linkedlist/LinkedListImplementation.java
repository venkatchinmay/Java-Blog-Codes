package com.corejava.programs.linkedlist;

public class LinkedListImplementation {
	
	public static  LinkedList<Integer> get() throws Exception {
		LinkedList<Integer> linkedList = new LinkedList<>();
	      linkedList.add(1);
	      linkedList.add(2);
	      linkedList.add(3);
	      linkedList.add(4);
	      linkedList.add(5);
	      linkedList.addAtPosition(13, 2);
	      linkedList.addLast(10);
		return linkedList;
	}

	public static void main(String[] args) throws Exception {
      LinkedList<Integer> linkedList = get();
     /* linkedList.add(6);
      linkedList.add(7);
      linkedList.add(8);
      linkedList.add(9);
      linkedList.add(10);
      linkedList.addAtPosition(12, 2);
      linkedList.addLast(11);*/
      linkedList.addFirst(100);
      String st = linkedList.traversingList();
      System.out.println(st);
	}

}
