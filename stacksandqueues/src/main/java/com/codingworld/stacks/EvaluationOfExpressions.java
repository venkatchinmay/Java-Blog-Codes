package com.codingworld.stacks;

import java.util.Scanner;

public class EvaluationOfExpressions {

	private Stack<String> postfixEvaluation = new StackWithUnLimitedCapacityWithArray<String>();
	private Stack<String> prefixEvaluation = new StackWithLimitedSizeWithArray<String>();


	private void calculatePostFixEvaluation(String symbol) throws Exception {
		if(isOperator(symbol)) {
			String topElement = postfixEvaluation.pop();
			String nextTopElement = postfixEvaluation.pop();
			if(isNumeric(topElement) && isNumeric(nextTopElement)) {
				long value = calculationOfValuesBasedOnOperator(nextTopElement,topElement,symbol);
				postfixEvaluation.push(String.valueOf(value));
			}else {
				String value = "(".concat(nextTopElement).concat(symbol).concat(topElement).concat(")");
				postfixEvaluation.push(value);
			}
		}else {
			postfixEvaluation.push(symbol);
		}
	}

	private void calculatePreFixEvaluation(String symbol) throws Exception {
		if(isOperator(symbol) && prefixEvaluation.size() > 0) {
			String topElement = prefixEvaluation.pop();
			String nextTopElement = prefixEvaluation.pop();
			if(isNumeric(topElement) && isNumeric(nextTopElement)) {
				long value = calculationOfValuesBasedOnOperator(topElement,nextTopElement,symbol);
				prefixEvaluation.push(String.valueOf(value));
			}else {
				String value = "(".concat(topElement).concat(symbol).concat(nextTopElement).concat(")");
				prefixEvaluation.push(value);
			}
		}else {
			prefixEvaluation.push(symbol);
		}
	}

	public String calculateResultOfExpressionWithPostfix(String expression) throws Exception {
		InfixToPostFixWithComma infixToPostFix = new InfixToPostFixWithComma();
		String postFixExpression = infixToPostFix.conversionOfInfixToPostExpression(expression);
		String [] elements = postFixExpression.split(",");
		for(String element : elements) {
			calculatePostFixEvaluation(element);
		}
		return postfixEvaluation.pop();
	}

	public String calculateResultOfExpressionWithPrefix(String expression) throws Exception {
		InfixToPreFix infixToPrefix = new InfixToPreFix();
		String postFixExpression = infixToPrefix.preFixInsertedWithCommasToEvaluateExpression(expression);
		String [] elements = postFixExpression.split(",");
		String [] reversingTheelements = reversingTheArray(elements);
		for(String reversingTheelement : reversingTheelements) {
			if(!reversingTheelement.isEmpty()) {
				calculatePreFixEvaluation(reversingTheelement);
			}
		}
		return prefixEvaluation.pop();
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

	private long calculationOfValuesBasedOnOperator(String value1, String value2, String operator) throws Exception {
		long val1 = Long.parseLong(value1);
		long val2 = Long.parseLong(value2);
		if(operator.equals("+")){
			return val1+val2;
		}else if(operator.equals("-")) {
			return val1-val2;
		}else if(operator.equals("/")) {
			return val1/val2;
		}else if(operator.equals("*")) {
			return val1*val2;
		}else if (operator.equals("^")) {
			return val1 ^ val2;
		}else {
			throw new Exception("UnSupported Operator ::: ".concat(operator).concat("Valid operators are +,-,/,*,^"));
		}
	}

	private boolean isOperator(String symbol) {
		String operators = "+-/*{}[]()^";
		return (operators.contains(symbol));
	}

	private String[] reversingTheArray(String [] array ) {
		String [] reversingTheArray = new String[array.length];
		int j = array.length-1;
		for(int i = 0; i< reversingTheArray.length; i++) {
			reversingTheArray[i] = array[j];
			j = j-1;
		}
		return reversingTheArray;
	}



	public static void main(String[] args) throws Exception {
		try(Scanner input = new Scanner(System.in)) {
			EvaluationOfExpressions expression = new EvaluationOfExpressions();
			System.out.println("Enter the Expression to evaluate ::: ");
			String myString= input.nextLine();
			myString = myString.replaceAll("\\s", ""); 
			System.out.println("Expression need to calculate ::"+ myString);
			String s = expression.calculateResultOfExpressionWithPostfix(myString);
			System.out.println("calculated result with postfix :::  "+s);
			String st = expression.calculateResultOfExpressionWithPrefix(myString);
			System.out.println("calculated result with prefix ::::  "+st);
		}
	}

}
