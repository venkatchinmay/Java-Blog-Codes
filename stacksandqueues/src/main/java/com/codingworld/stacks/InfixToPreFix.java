package com.codingworld.stacks;

/**
 * pseudo code ::
 * a. reverse the infix expression 
 * b. replace braces in reverse expression (eg :: ) with ( , ( with ))
 * c. calculate postfix 
 * d. reverse the expression 
 * 
 */

public class InfixToPreFix {
	
	private Stack<String> stack = new StackWithUnLimitedCapacityWithArray<String>();
	private String postFix = null;
	
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
	
	private String conversionOfInfixToPostExpression(String infix) throws Exception {
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
	
	private String replacedWithBracesString(String string) {
		StringBuilder replace = new StringBuilder();
		for(char ch : string.toCharArray()) {
			if(ch == '(') {
				replace.append(')');
			}else if(ch == ')') {
				replace.append('(');
			}else if(ch == '{') {
				replace.append('}');
			}else if(ch == '}') {
				replace.append('{');
			}else if(ch == '[') {
				replace.append(']');
			}else if(ch == ']') {
				replace.append('[');
			}else {
				replace.append(ch);
			}
		}
		return replace.toString();
	}
	
	private String reverseString(String st) {
		StringBuilder input = new StringBuilder(); 
		input.append(st);
		 return input.reverse().toString();
	}
	
	public String conversionOfInfixToPrefixExpression(String infix) throws Exception {
		String reverseInfix = reverseString(infix);
		String replaceWithBraces = replacedWithBracesString(reverseInfix);
		String postfixExpression = conversionOfInfixToPostExpression(replaceWithBraces);
	    return reverseString(postfixExpression);
	}
	
	public static void main(String args[]) throws Exception {
		String infix = "(a+b*c)";
		System.out.println(infix);
		InfixToPreFix infixToPreFix = new InfixToPreFix();
		String preFix = infixToPreFix.conversionOfInfixToPrefixExpression(infix);
		System.out.println("preFix ::: "+preFix);
	}

}