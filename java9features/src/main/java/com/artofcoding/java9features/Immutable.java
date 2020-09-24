package com.artofcoding.java9features;

import java.util.Arrays;
import java.util.List;


public class Immutable {

	public static void main(String[] args) {
      List<Integer> numbers = Arrays.asList(1,2,3);
	   //numbers.add(4);
      // we are thinking is immutable, you r wrong 
      //numbers.set(0, 4);
      // mutable 
      //System.out.println(numbers);
      System.out.println("Arrays.asList(1,2,3) ::: "+numbers.getClass().getName());
      
      // immutable 
      List<Integer> numbersM = List.of(1,2,3);
      //numbers.add(4);(un supported operation)
      // we are thinking is immutable, you r wrong 
      //numbersM.set(0, 4);
      // mutable 
      //System.out.println(numbersM);
      System.out.println("List.of(1,2,3) ::: "+numbersM.getClass().getName());
      /*System.out.println(Set.of("Tom","Jerry","Tom"));
      // it gives an error during the runtime and where as HashSet will allow 
      // dont get order of iteration, reality we are getting ordering 
      // In this no order follows 
      System.out.println(Map.of("a",1,"b",2));
     // System.out.println(Map.of("a",1,"b")); -> error
      System.out.println(Map.of("a",1,"b",2,"c",3,5,"z"));
      // you should be careful at those points 
      //Map<String,Integer> map = Map.of("a",1,"b",2,"c",3,5,"z");--> error
      //System.out.println(Map<String,Integer>.of("a",1,"b",2,"c",3,5,"z")); --> error*/
      
	}

}
