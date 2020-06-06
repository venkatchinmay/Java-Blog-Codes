package com.corejava.programs.doublelinkedlist;

public class DoubleLinkedListImplementation {
	
	public static  DoubleLinkedList<Integer> get() throws Exception {
		DoubleLinkedList<Integer> DoubleLinkedList = new DoubleLinkedList<>();
	      DoubleLinkedList.add(1);
	      DoubleLinkedList.add(2);
	      DoubleLinkedList.add(3);
	      DoubleLinkedList.add(4);
	      DoubleLinkedList.add(5);
	      DoubleLinkedList.add(3);
	      DoubleLinkedList.add(4);
	      DoubleLinkedList.add(3);
	      DoubleLinkedList.add(3);
	      DoubleLinkedList.add(5);
	      DoubleLinkedList.add(5);
	      DoubleLinkedList.add(5);
	      DoubleLinkedList.add(5);
	      DoubleLinkedList.add(3);
	      DoubleLinkedList.addAtPosition(13, 2);
	      DoubleLinkedList.addLast(10);
		return DoubleLinkedList;
	}

	public static void main(String[] args) throws Exception {
      DoubleLinkedList<Integer> DoubleLinkedList = get();
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
      System.out.println("-----------------------");
      DoubleLinkedList.removeByValue(1);
      DoubleLinkedList.removeByValue(2);
      DoubleLinkedList.removeByValue(10);
      String st2 = DoubleLinkedList.traversingList();
      System.out.println(st2);
      DoubleLinkedList.removeByValue(3);
      String st3 = DoubleLinkedList.traversingList();
      System.out.println(st3);
      String reverse2 = DoubleLinkedList.traversingListReverse();
      System.out.println(reverse2);
      DoubleLinkedList.removeByReversePosition(1);
      DoubleLinkedList.removeByReversePosition(3);
      String st4 = DoubleLinkedList.traversingList();
      System.out.println(st4);
      String reverse3 = DoubleLinkedList.traversingListReverse();
      System.out.println(reverse3);
	}

}
