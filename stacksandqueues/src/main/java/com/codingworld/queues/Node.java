package com.codingworld.queues;

public class Node<T> {
   Node<T> nextNode;
   T value;
   
   public Node(T value,Node<T> nextNode) {
	   this.value = value;
	   this.nextNode = nextNode;
   }
}
