package com.codingworld.stacks;

/**
 * pseudo code ::
 * 
 * infix to postfix :::
 * 
 * rules ::
 * (a) if symbol is operand --> concat to string 
 * 
 * operators:
 * 
 * (b) stack is empty --> push
 * (c) precedence(symbol) > precedence(top element in stack) and symbols != endbrackets --> push
 * (d) top element of stack == beginning brackets --> push
 * (e) symbol == end brackets --> 
 *       pop the elements from the stack up to the beginning bracket
 *       concat to the string 
 *       pop beginning bracket also and do not concat to the string 
 * (f) precedence(symbol) <= precedence(top element in stack) -->
 *       iterate stack: 
 *         if precedence(symbol) < precedence(top element in stack) or 
 *         top of the stack element != brackets or
 *         precedence(symbol) == precedence(top element in stack) and associavity == LTR
 *             pop the element and concat to the String 
 *         if precedence(symbol) > precedence(top element in stack) 
 *            or top of the stack element == brackets 
 *            or precedence(symbol) == precedence(top element in stack) and associavity == RTL
 *            push the symbol in to the stack
 *            break the loop
 *       while iteration if stack is empty --> push the symbol in to the stack
 *  (g) pop the all elements in stack and concat to the string      
 */

public class InfixToPostFix {
	
	private Stack<String> stack = new StackWithUnLimitedCapacityWithArray<String>();
	private static String postFix = null;
	
	private int precedence(String operator) {
		if(operator.equals("{") || operator.equals("}") || operator.equals("(") || 
				operator.equals(")") || operator.equals("[") || operator.equals("]")) {
			return 4;
		}else if (operator.equals("^")) {
			return 3;
		}else if(operator.equals("*") || operator.equals("/")) {
			return 2;
		}else if(operator.equals("+") || operator.equals("-")) {
			return 1;
		}
		return 0;
	}
	
	private String associavity(String operator) {
	    if (operator.equals("^")) {
			return "RTL";
		}else if(operator.equals("*") || operator.equals("/")) {
			return "LTR";
		}else if(operator.equals("+") || operator.equals("-")) {
			return "LTR";
		}
		return "LTR";
	}
	
	private boolean isOperand(String symbol) {
		String operators = "+-/*{}[]()^";
		return (!operators.contains(symbol));
	}
	
	private void infixToPostFix(String symbol) throws Exception {
		String endBraces = ")]}";
		String startBraces = "([{";
		String allBraces = "()[]{}";
		if(isOperand(symbol)) {
			if(postFix != null) {
				postFix = postFix.concat(symbol);
			}else {
				postFix = symbol;
			}
		}else {
			if(stack.size() == 0) {
				stack.push(symbol);
			}else if((precedence(symbol)> precedence(stack.peek()) && !endBraces.contains(symbol))|| startBraces.contains(stack.peek())) {
				stack.push(symbol);
			}else if(endBraces.contains(symbol)) {
				while(stack.size() > 0) {
					if(startBraces.contains(stack.peek())) {
						stack.pop();
						break;
					}
					String element = stack.pop();
					postFix = postFix.concat(element);
				}
			}else {
				while(stack.size() > 0) {
					if((precedence(symbol) < precedence(stack.peek()) && !allBraces.contains(stack.peek())) || 
							(precedence(symbol) == precedence(stack.peek())&& associavity(symbol).equals("LTR") && !allBraces.contains(stack.peek()))){
						String element = stack.pop();
						postFix = postFix.concat(element);
					}else {
						stack.push(symbol);
						break;
					}
				}
				if(stack.size() == 0) {
					stack.push(symbol);
				}
			}
		}
	}
	
	
	public String conversionOfInfixToPostExpression(String infix) throws Exception {
		char ch [] = infix.toCharArray();
	       for(char t : ch) {
	    	   infixToPostFix(String.valueOf(t));
	       }
	       if(stack.size()> 0) {
	    	   while(stack.size()> 0) {
	    		   postFix= postFix.concat(stack.pop());   
	    	   }
	       }
	       return postFix;
	}
	
	
	
	public static void main(String args[]) throws Exception {
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		InfixToPostFix infixToPostFix = new InfixToPostFix();
		String postFix = infixToPostFix.conversionOfInfixToPostExpression(infix);
		System.out.println("postFix ::: "+postFix);
	}

}
