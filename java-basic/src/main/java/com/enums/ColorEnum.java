package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ColorEnum {

	RED("red","红色"),
	GREEN("green","绿色"),
	YELLOW("yellow","黄色");

	private final String key;
	private final String value;

	public static List<Map<String,String>> getBoth(){
		return Arrays.stream(ColorEnum.values()).map(item-> Collections.singletonMap(item.key,item.value)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		System.out.println(ColorEnum.getBoth());
	}
}
