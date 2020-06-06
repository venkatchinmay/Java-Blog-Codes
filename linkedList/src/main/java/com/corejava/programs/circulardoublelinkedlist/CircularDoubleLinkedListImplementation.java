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
      System.out.println("------------------------------");
      CircularDoubleLinkedList.removeByValue(1);
      CircularDoubleLinkedList.removeByValue(2);
      CircularDoubleLinkedList.removeByValue(10);
      String st2 = CircularDoubleLinkedList.traversingList();
      System.out.println(st2);
      CircularDoubleLinkedList.removeByValue(3);
      String st3 = CircularDoubleLinkedList.traversingList();
      System.out.println(st3);
      String reverse2 = CircularDoubleLinkedList.traversingListReverse();
      System.out.println(reverse2);
      CircularDoubleLinkedList.removeElementAtReversePosition(1);
      String st5 = CircularDoubleLinkedList.traversingList();
      System.out.println(st5);
      String reverse4 = CircularDoubleLinkedList.traversingListReverse();
      System.out.println(reverse4);
      CircularDoubleLinkedList.removeElementAtReversePosition(3);
      String st4 = CircularDoubleLinkedList.traversingList();
      System.out.println(st4);
      String reverse3 = CircularDoubleLinkedList.traversingListReverse();
      System.out.println(reverse3);
	}

}
