package com.corejava.programs.doublelinkedlist;

public class DoubleLinkedListImplementation {
	
	public static  DoubleLinkedList<Integer> get() throws Exception {
		DoubleLinkedList<Integer> DoubleLinkedList = new DoubleLinkedList<>();
	      DoubleLinkedList.add(1);
	      DoubleLinkedList.add(2);
	      DoubleLinkedList.add(3);
	      DoubleLinkedList.add(4);
	      DoubleLinkedList.add(5);
	      DoubleLinkedList.addAtPosition(13, 2);
	      DoubleLinkedList.addLast(10);
		return DoubleLinkedList;
	}

	public static void main(String[] args) throws Exception {
      DoubleLinkedList<Integer> DoubleLinkedList = get();
     /* DoubleLinkedList.add(6);
      DoubleLinkedList.add(7);
      DoubleLinkedList.add(8);
      DoubleLinkedList.add(9);
      DoubleLinkedList.add(10);
      DoubleLinkedList.addAtPosition(12, 2);
      DoubleLinkedList.addLast(11);*/
      DoubleLinkedList.addFirst(100);
      String st = DoubleLinkedList.traversingList();
      String reverse = DoubleLinkedList.traversingListReverse();
      System.out.println(DoubleLinkedList.size());
      System.out.println(st);
      System.out.println(reverse);
      DoubleLinkedList.addfromLastPosition(44, 2);
      String st1 = DoubleLinkedList.traversingList();
      String reverse1 = DoubleLinkedList.traversingListReverse();
      System.out.println(DoubleLinkedList.size());
      System.out.println(st1);
      System.out.println(reverse1);
	}

}
