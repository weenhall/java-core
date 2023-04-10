package com.ween.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	private static final List<Fruit> favorite = new ArrayList<>();

	static {
		favorite.add(new Fruit(1, "APPLE", 100f));
		favorite.add(new Fruit(2, "BANANA", 150f));
		favorite.add(new Fruit(3, "PEAR", 80f));
	}

	public static void main(String[] args) {
//		createStreamFromCollections();
//		createStreamFromArrays();
//		streamFilter();
//		streamMathMethod();
//		streamList2Map();
		streamListSort();
	}

	public static void createStreamFromCollections() {
		Collection<String> collection = Arrays.asList("APPLE", "BANANA", "PEAR");
		Stream<String> stream = collection.stream();
		stream.forEach(System.out::println);
	}

	public static void createStreamFromArrays() {
		Stream<String> stream = Stream.of("APPLE", "BANANA", "PEAR");
		stream.forEach(System.out::println);

		String[] arr = new String[]{"APPLE", "BANANA", "PEAR"};
		stream = Arrays.stream(arr);
		stream.forEach(System.out::println);
	}

	public static void streamFilter() {
		List<Float> prices = favorite.stream().map(Fruit::getPrice)
				.filter((price -> price >= 100f)).collect(Collectors.toList());
		List<Fruit> fruits = favorite.stream()
				.filter((fruit -> fruit.getPrice() >= 100f)).collect(Collectors.toList());
		prices.forEach(System.out::println);
		fruits.forEach(System.out::println);
	}

	public static void streamMathMethod(){
		double totalPrice= favorite.stream().mapToDouble(Fruit::getPrice).sum();
		System.out.println(totalPrice);

		Fruit expensive=favorite.stream().max((f1,f2)->f1.getPrice()>f2.getPrice()?1:-1).get();
		System.out.println(expensive);

		Fruit cheap=favorite.stream().min((f1,f2)->f1.getPrice()>f2.getPrice()?1:-1).get();
		System.out.println(cheap);
	}

	public static void streamList2Map(){
		Map<String,Float> fruitMap=favorite.stream().collect(Collectors.toMap(Fruit::getName, Fruit::getPrice));
		System.out.println(fruitMap);

		Map<String,Fruit> stringFruitMap=favorite.stream().collect(Collectors.toMap(Fruit::getName,Function.identity()));
		System.out.println(stringFruitMap);

		List<Float> prices=favorite.stream()
				.map(Fruit::getPrice)
				.filter(price -> price >100f)
				.collect(Collectors.toList());
		System.out.println(prices);
	}

	public static void streamListSort(){
		List<Float> naturalOrder=favorite.stream().map(Fruit::getPrice).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(naturalOrder);

		List<Float> ascOrder=favorite.stream().map(Fruit::getPrice).sorted(Float::compareTo).collect(Collectors.toList());
		System.out.println(ascOrder);

		List<Float> descOrder=favorite.stream().map(Fruit::getPrice).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(descOrder);
	}
}
