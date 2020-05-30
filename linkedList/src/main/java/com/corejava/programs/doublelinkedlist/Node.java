package com.corejava.programs.doublelinkedlist;

public class Node<T> {
    T value;
    Node<T> previous;
    Node<T> next;
    
    public Node(Node<T>previous,T value,Node<T> next) {
    	this.previous = previous;
    	this.value = value;
    	this.next = next;
    }
}
