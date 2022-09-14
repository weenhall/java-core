package com.algorithm.search;

/**
 * @author ween
 */
public interface SearchAlgorithm {

    /**
     * 比较
     * @param array
     * @param key
     * @param <T>
     * @return
     */
    <T extends Comparable<T>> int find(T[] array, T key);
}
