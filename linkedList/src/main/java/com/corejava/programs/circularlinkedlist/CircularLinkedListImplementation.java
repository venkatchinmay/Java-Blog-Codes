package com.corejava.programs.circularlinkedlist;

public class CircularLinkedListImplementation {
	
	public static  CircularLinkedList<Integer> get() throws Exception {
		CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
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
      CircularLinkedList<Integer> CircularLinkedList = get();
		//CircularLinkedList<Integer> CircularLinkedList = new CircularLinkedList<>();
		CircularLinkedList.add(5);
		CircularLinkedList.addFirst(100);
      String st = CircularLinkedList.traversingList();
      System.out.println(CircularLinkedList.size());
      System.out.println(st);
      CircularLinkedList.removeByValue(1);
      CircularLinkedList.removeByValue(2);
      //CircularLinkedList.removeByValue(10);
      String st2 = CircularLinkedList.traversingList();
      System.out.println(st2);
      CircularLinkedList.removeByValue(3);
      CircularLinkedList.removeByValue(5);
      String st1 = CircularLinkedList.traversingList();
      System.out.println(st1);
	}

}
