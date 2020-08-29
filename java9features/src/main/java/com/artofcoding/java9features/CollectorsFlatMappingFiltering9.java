package com.artofcoding.java9features;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsFlatMappingFiltering9 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> filter = list.stream()
				.collect(Collectors.filtering(e -> e > 5,Collectors.toList()));
		filter.forEach(System.out::println);

		// java 8
		List<Integer> beforeJava9 = Stream.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10))
				.flatMap(l -> l.stream())
				.collect(Collectors.toList());
		System.out.println(beforeJava9);

		List<Integer> stlist = Stream.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10))
				.collect(Collectors.flatMapping(l -> l.stream(),
						Collectors.toList()));

		System.out.println(stlist);

		
		//Java 9 
		Map<Integer, List<Integer>> map =
		Stream.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10))
		.collect(
				Collectors.groupingBy(
						Collection::size,
						Collectors.flatMapping(
								l -> l.stream()
								.filter(i -> i % 2 == 0),
								Collectors.toList())
						)
				);
		System.out.println(map);   
	}

}
