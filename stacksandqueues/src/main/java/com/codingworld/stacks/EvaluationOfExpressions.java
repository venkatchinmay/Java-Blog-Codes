package com.codingworld.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluationOfExpressions {
	
	
	private static boolean isOperator(String symbol) {
		String operators = "+-/*{}[]()^";
		return (operators.contains(symbol));
	}
	
	private static String[] convertExpressionIntoArray(String expression) {
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

	public static void main(String[] args) {
		String myString= "abc+b*(c^d-e)^(fkll+g*h)-";
		String [] finalArray = convertExpressionIntoArray(myString);
		System.out.println(Arrays.toString(finalArray));

	}

}
