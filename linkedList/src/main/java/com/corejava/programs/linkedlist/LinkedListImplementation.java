package com.corejava.programs.linkedlist;

public class LinkedListImplementation {
	
	public static  LinkedList<Integer> get() throws Exception {
		LinkedList<Integer> linkedList = new LinkedList<>();
	      linkedList.add(1);
	      linkedList.add(2);
	      linkedList.add(3);
	      linkedList.add(3);
	      linkedList.add(4);
	      linkedList.add(3);
	      linkedList.add(3);
	      linkedList.add(5);
	      linkedList.add(5);
	      linkedList.add(5);
	      linkedList.add(5);
	      linkedList.add(3);
	      linkedList.addAtPosition(13, 2);
	      linkedList.addLast(10);
		return linkedList;
	}

	public static void main(String[] args) throws Exception {
      LinkedList<Integer> linkedList = get();
      String st = linkedList.traversingList();
      System.out.println(linkedList.size());
      System.out.println(st);
      linkedList.removeByValue(1);
      linkedList.removeByValue(2);
      linkedList.removeByValue(10);
      String st2 = linkedList.traversingList();
      System.out.println(st2);
      linkedList.removeByValue(3);
      String st1 = linkedList.traversingList();
      System.out.println(st1);
      linkedList.removeAll();
      String st3 = linkedList.traversingList();
      System.out.println(st3);
      
	}

}
