package com.codingworld.stacks;

public class StackTest {
	
	public static void main(String[] args) throws Exception {
       StackWithLimitedSizeWithArray<Integer> stack = new StackWithLimitedSizeWithArray<Integer>();
       stack.push(10);
       stack.push(20);
       stack.push(30);
       stack.push(40);
       System.out.println(stack.printStackElements());
       System.out.println(stack.peek());
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println(stack.printStackElements());
       System.out.println("---------------------------------------------------");
       StackWithUnLimitedCapacityWithArray<Integer> stackUnlimited = new StackWithUnLimitedCapacityWithArray<Integer>();
       stackUnlimited.push(10);
       stackUnlimited.push(20);
       stackUnlimited.push(30);
       stackUnlimited.push(40);
       System.out.println(stackUnlimited.printStackElements());
       System.out.println(stackUnlimited.peek());
       System.out.println(stackUnlimited.pop());
       System.out.println(stackUnlimited.pop());
       System.out.println(stackUnlimited.printStackElements());
	}

}

