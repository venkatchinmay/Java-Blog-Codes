package com.codingworld.queues;

public class TestingQueues {
	
	public static void main(String args[]) throws Exception{
		QueueImplementation<Integer> queue = new QueueImplementation<>();
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		System.out.println(queue.printElementsInaQueue());
		System.out.println(queue.size());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.printElementsInaQueue());
		System.out.println(queue.size());
	}

}
