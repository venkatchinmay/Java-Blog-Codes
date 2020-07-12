package com.codingworld.stacks;

import java.util.ArrayList;
import java.util.List;

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
		String ch [] = convertExpressionIntoArray(infix);
	       for(String t : ch) {
	    	   infixToPostFix(t);
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
	
	private String insertCommas(char[] characters) {
		String insertedCommas = null;
		for(char character : characters) {
			if(insertedCommas == null) {
				insertedCommas = String.valueOf(character);
				continue;
			}else if(isOperator(String.valueOf(character))) {
				if(insertedCommas.lastIndexOf(",") != (insertedCommas.length()-1)) {
					insertedCommas = insertedCommas.concat(",");
				}
				insertedCommas = insertedCommas.concat(String.valueOf(character));
				insertedCommas = insertedCommas.concat(",");
				continue;
			}
			insertedCommas = insertedCommas.concat(String.valueOf(character));
		}
		return insertedCommas;
	}
	
	
	
	private String reverseInfixExpression(String st) {
		String insertedCommas = insertCommas(st.toCharArray());
		String [] strArr = insertedCommas.split(",");
		StringBuilder input = new StringBuilder(); 
		for(int i= strArr.length-1; i >= 0;i--) {
			input.append(strArr[i]);
		}
		return input.toString();
	}
	
	private String reversepostFixExpression(String postfix) {
		StringBuilder input = new StringBuilder();
		String arr[] = postfix.split(",");
		for(int i = arr.length-1; i >= 0; i--) {
			input.append(arr[i]);
			input.append(",");
		}
		return input.toString();
	}
	
	public String conversionOfInfixToPrefixExpression(String infix) throws Exception {
		String reverseInfix = reverseInfixExpression(infix);
		String replaceWithBraces = replacedWithBracesString(reverseInfix);
		String postfixExpression = conversionOfInfixToPostExpression(replaceWithBraces);
		return reversepostFixExpression(postfixExpression);
	}
	
	public String preFixInsertedWithCommasToEvaluateExpression(String infix) throws Exception {
		String reverseInfix = reverseInfixExpression(infix);
		String replaceWithBraces = replacedWithBracesString(reverseInfix);
		InfixToPostFixWithComma infixToPostFix = new InfixToPostFixWithComma();
		String postfixExpression = infixToPostFix.conversionOfInfixToPostExpression(replaceWithBraces);
		return reversepostFixExpression(postfixExpression);
	}
	
	private  boolean isOperator(String symbol) {
		String operators = "+-/*{}[]()^";
		return (operators.contains(symbol));
	}
	
	private  String[] convertExpressionIntoArray(String expression) {
		List<String> elements = new ArrayList<String>();
		char[] splittingArray = expression.toCharArray();
		String operand = null;
		for(char c : splittingArray) {
			if(isOperator(String.valueOf(c))){
				if(operand != null) {
				  elements.add(operand);
				}
				elements.add(String.valueOf(c));
				operand = null;
			}else {
				if(operand != null) {
					operand = operand.concat(String.valueOf(c));
				}else {
					operand = String.valueOf(c);
				}
			}
		}
		if(operand != null) {
			 elements.add(operand);
		}
		 String[] arr = new String [elements.size()]; 
	        arr = elements.toArray(arr); 
		return arr;
	}

	
	public static void main(String args[]) throws Exception {
		String infix = "A+B*C/(E-F)";
		System.out.println(infix);
		infix = infix.replaceAll("\\s", ""); 
		InfixToPreFix infixToPreFix = new InfixToPreFix();
		String preFix = infixToPreFix.conversionOfInfixToPrefixExpression(infix);
		System.out.println("preFix ::: "+preFix);
		//System.out.println(infixToPreFix.preFixInsertedWithCommasToEvaluateExpression(infix));
	}

}
