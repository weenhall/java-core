package com.algorithm.search;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * 二分查找法/折半查找
 */
public class BinarySearch implements SearchAlgorithm {
	@Override
	public <T extends Comparable<T>> int find(T[] array, T key) {
		return search(array, key, 0, array.length);
	}

	private <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
		if (right < left) {
			return -1;//要查找的元素不在数组中
		}
		int median = (left + right) >>> 1;//右移比除法更高效
		int comp = key.compareTo(array[median]);
		if (comp == 0) {
			return median;
		} else if (comp < 0) {
			return search(array, key, left, median - 1);
		} else {
			return search(array, key, median + 1, right);
		}
	}

	public static void main(String[] args) {
		Random r = ThreadLocalRandom.current();
		int size = 100;
		int maxElement = 100000;
		//generate random data
		Integer[] arr = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().boxed().toArray(Integer[]::new);

		//The element should be found
		int shouldFound = arr[r.nextInt(size - 1)];
		System.out.println("需要找到的元素:" + shouldFound);

		BinarySearch search = new BinarySearch();
		int atIndex = search.find(arr, shouldFound);
		System.out.println(format(
				"需要找到的元素: %d. 找到 %d 在数组中的位置为 %d. 数组长度为 %d",
				shouldFound, arr[atIndex], atIndex, size
		));
	}
}
