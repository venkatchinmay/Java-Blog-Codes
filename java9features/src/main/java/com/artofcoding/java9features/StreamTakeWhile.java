package com.artofcoding.java9features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTakeWhile {

	public static void main(String[] args) {
		// java 8
		List<Integer> numbers = Arrays.asList(11,12,13,14,51,16,17,81,91);
		/*System.out.println("=========== FILTER ===================");
		numbers.stream()
		.filter(e -> e < 50)
		.forEach(System.out::println);

		System.out.println("=========== LIMIT ===================");
		numbers.stream()
		.limit(3)
		.forEach(System.out::println);

		System.out.println("=========== SKIP ===================");
		numbers.stream()
		.skip(7)
		.forEach(System.out::println);*/
		
		System.out.println("=========== Imperative Java 8 ===================");
		
		for(int number : numbers){
			if(number > 50)
				break;
			System.out.println(number);
		}

		System.out.println("=========== functional with take-while Java 9 ===================");
		// java 9
		numbers.stream()
		.takeWhile(e -> e<50)
		.forEach(System.out::println);
         
         System.out.println("=========== Imperative Java 8 ===================");
         boolean isAllowed = false;
         for(int number : numbers){
        	 if(number < 50 && !isAllowed) {
        		 continue;
        	 }
        	 isAllowed = true;
        	 System.out.println(number);
         }
         
         System.out.println("=========== functional with drop-while Java 9 ===================");
         numbers.stream()
         .dropWhile(e -> e<50)
         .forEach(System.out::println);

      //-------------------------------
        // imperative style of coding 
         for(int i=0; i<5; i++) {
        	 System.out.println("------");
         }
         for(int i=0; i<=5; i++) {
        	 System.out.println("------");
         }
         for(int i=0; i<=5; i= i+2) {
        	 System.out.println("------");
         }
         for(int i=0;; i= i+3) {
        	 if(i> 20)
        		 break;
        	 System.out.println("------");
         }
        // functional (go to colleagues and say)
        IntStream.range(0,5)
        .forEach(System.out::println);
        IntStream.rangeClosed(0,5)
        .forEach(System.out::println);
        // one person who hates functional code 
        // java 8 < I am sorry> 
        // java 9 - intutive 
        // 4 popular interfaces 
        // supplier,Consumer,Perdicate,Function
    //  for(int i=0; i<=5; i= i+2) 
        //for(seed,Perdicate,Function)
        IntStream.iterate(0,i-> i<=5, i-> i+2)
        .forEach(System.out::println);
        // dont do 
       // IntStream.iterate(0,, i-> i+2)
       // .forEach(System.out::println);
        IntStream.iterate(0, i-> i+3)
        .takeWhile(e -> e > 20)
        .forEach(System.out::println);

	}

	// filter takes a Perdicate . It is like a gate that opens or closes per element	
	// limit takes a integer. it is like a door that is open. but it may closes for ever
	// skip takes a integer. it is like a door closed and that is opened forever.(opposite to limit)

	// defect in java 8 
	// imperative style - break(java 8 no easy)
	// gift to 3 people 
	// gift to see a person with hat until. need logical limit 	
	// Haskell  ---------------------- JAVA
	// take(number) ------------------ limit(int)
	// drop(number)	------------------ skip(int)
	//takeWhile(Predicate) ----------- takeWhile(Predicate)
	//dropWhile(Predicate)	--------- dropWhile(Predicate)
	// break(imperative) ===== takeWhile(functional)	

}
