package com.corejava.programs.circulardoublelinkedlist;

public class CircularDoubleLinkedListImplementation {
	
	public static  CircularDoubleLinkedList<Integer> get() throws Exception {
		CircularDoubleLinkedList<Integer> CircularDoubleLinkedList = new CircularDoubleLinkedList<>();
	      CircularDoubleLinkedList.add(1);
	      CircularDoubleLinkedList.add(2);
	      CircularDoubleLinkedList.add(3);
	      CircularDoubleLinkedList.add(4);
	      CircularDoubleLinkedList.add(5);
	      CircularDoubleLinkedList.addAtPosition(13, 2);
	      CircularDoubleLinkedList.addLast(10);
		return CircularDoubleLinkedList;
	}

	public static void main(String[] args) throws Exception {
      CircularDoubleLinkedList<Integer> CircularDoubleLinkedList = get();
      CircularDoubleLinkedList.addFirst(100);
      String st = CircularDoubleLinkedList.traversingList();
      System.out.println(st);
      String reverse = CircularDoubleLinkedList.traversingListReverse();
      System.out.println(CircularDoubleLinkedList.size());
      System.out.println(reverse);
      CircularDoubleLinkedList.addfromLastPosition(44, 2);
      CircularDoubleLinkedList.addfromLastPosition(64, 1);
      String st1 = CircularDoubleLinkedList.traversingList();
      String reverse1 = CircularDoubleLinkedList.traversingListReverse();
      System.out.println(CircularDoubleLinkedList.size());
      System.out.println(st1);
      System.out.println(reverse1);
	}

}
