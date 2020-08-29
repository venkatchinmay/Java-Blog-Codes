package com.artofcoding.java9features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Optional {
	
	// please dont do this at your home or office 
	// use optional as a return type , not as a parameter to the function 
	// Y ? 
	// u burden the users 
	public static void process(java.util.Optional<Integer> result) {
	    result.get(); // dont do this 
	    // get is to forget because it blows without telling you 
	    // NoSuchElement 
	    result.orElseThrow(); // it clearly tells you the intension
	    result.orElse(0); // gives value or return for me 0 
	    if(result.isPresent()) {
	    	
	    }else {
	    	
	    }
	    result.ifPresent(value -> System.out.println(value));
	    result.ifPresentOrElse(value -> System.out.println(value), ()-> System.out.println());
	    
	    //Optional<T>                              Present           Absent 
	    // orElse(substitute)                      T data            T substitute 
	    // or(() -> Optional.of(substitute))       Optional(data)    Optional(substitute)
	    //result.or();
	}
	
	public static void processStream(Stream<Integer> result) {
		result.forEach(System.out::println);
	}
	
	public static void process() {};
	public static void process(int value) {};

	public static void main(String[] args) {
     List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	  /*numbers.stream()
	         .filter(e-> e> 5)
	         .findFirst();
	  numbers.stream()
      .filter(e-> e> 50)
      .findFirst();// Null*/
     
	  //Null is a smell
	  // java 9 
	  // effective java says that returns an empty collection 
	  // single Object ---> ????
	  // Optional is the solution for it 
	  java.util.Optional<Integer> op1 = numbers.stream()
      .filter(e-> e> 5)
      .findFirst();
	  
	  java.util.Optional<Integer> op2 = numbers.stream()
		      .filter(e-> e> 50)
		      .findFirst();
	  System.out.println("Ok");
	  // How to get the value out of the optional
	  process( numbers.stream()
      .filter(e-> e> 5)
      .findFirst());
	  
	  process( numbers.stream()
		      .filter(e-> e> 50)
		      .findFirst());
	  
	  processStream(numbers.stream()
		      .filter(e-> e> 8));
	  System.out.println("---------");
	  processStream(numbers.stream()
		      .filter(e-> e> 9));
	  System.out.println("---------");
	  processStream(numbers.stream()
		      .filter(e-> e> 10));
	  System.out.println("---------");
	  /*processStream(numbers.stream()
		      .filter(e-> e> 5)
		      .findFirst());*/
	  // Stream can iterate with empty and with one element 
	  // Optional may have 0 or 1 
	  // Stream may have 0,1 or more values 
	  // Optional is a subset of Stream and why can't I used it 
	  // if you have an Optional create a stream 
	  processStream(numbers.stream()
      .filter(e-> e> 5)
      .findFirst().stream());
	  
	  // map
	  //(Option with value X).map(f) -> Optionwithvalue Y
	  //(Option with empty X).map(f) -> Option empty Y
	  // Map transforms optional with value,does not touch empty
	}

}
