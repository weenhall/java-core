package com.ween.optional;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		Optional<String> opt=Optional.of("String text");
		opt.ifPresent(System.out::println);

		String emptyText=null;
		String text=Optional.ofNullable(emptyText).orElse("String Text");
		text=Optional.ofNullable(emptyText).orElseGet(()->"String Text");
		text=Optional.of(emptyText).orElseThrow(IllegalAccessError::new);
	}
}
