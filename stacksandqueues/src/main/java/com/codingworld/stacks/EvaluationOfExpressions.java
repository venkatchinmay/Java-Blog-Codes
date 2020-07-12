package com.codingworld.stacks;

import java.util.ArrayList;
import java.util.List;

public class EvaluationOfExpressions {
	
	private Stack<String> postfixEvaluation = new StackWithUnLimitedCapacityWithArray<String>();
	
	private void calculatePostFixEvaluation(String symbol) throws Exception {
		if(isOperator(symbol)) {
			String topElement = postfixEvaluation.pop();
			System.out.println(postfixEvaluation.printStackElements());
			String nextTopElement = postfixEvaluation.pop();
			System.out.println(postfixEvaluation.printStackElements());
			if(isNumeric(topElement) && isNumeric(nextTopElement)) {
			   double value = calculationOfValuesBasedOnOperator(nextTopElement,topElement,symbol);
			    postfixEvaluation.push(String.valueOf(value));
			    System.out.println(postfixEvaluation.printStackElements());
			}else {
				String value = "(".concat(nextTopElement).concat(symbol).concat(topElement).concat(")");
				 postfixEvaluation.push(value);
				 System.out.println(postfixEvaluation.printStackElements());
			}
		}else {
			postfixEvaluation.push(symbol);
			System.out.println(postfixEvaluation.printStackElements());
		}
	}
	
	public String calculateResultOfExpression(String expression) throws Exception {
		InfixToPostFix infixToPostFix = new InfixToPostFix();
		String postFixExpression = infixToPostFix.conversionOfInfixToPostExpression(expression);
		System.out.println(postFixExpression);
		postFixExpression = "231*+9-";
		char[] elements = postFixExpression.toCharArray();
		for(char element : elements) {
			calculatePostFixEvaluation(String.valueOf(element));
		}
		return postfixEvaluation.pop();
	}
	
	private boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	private double calculationOfValuesBasedOnOperator(String value1, String value2, String operator) throws Exception {
		double val1 = Double.parseDouble(value1);
		double val2 = Double.parseDouble(value2);
		if(operator.equals("+")){
			return val1+val2;
		}else if(operator.equals("-")) {
			return val1-val2;
		}else if(operator.equals("/")) {
			return val1/val2;
		}else if(operator.equals("*")) {
			return val1*val2;
		}else if (operator.equals("^")) {
			return (int)val1 ^(int)val2;
		}else {
			throw new Exception("UnSupported Operator ::: ".concat(operator).concat("Valid operators are +,-,/,*,^"));
		}
	}
	
	
	private boolean isOperator(String symbol) {
		String operators = "+-/*{}[]()^";
		return (operators.contains(symbol));
	}
	
	private String[] convertExpressionIntoArray(String expression) {
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

	public static void main(String[] args) throws Exception {
		EvaluationOfExpressions expression = new EvaluationOfExpressions();
		String myString= "a+b*(c^d-e)^(f+g*h)-i";
		String s = expression.calculateResultOfExpression(myString);
		System.out.println("value"+s);

	}

}
