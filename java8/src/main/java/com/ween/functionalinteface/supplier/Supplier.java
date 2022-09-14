package com.ween.functionalinteface.supplier;

/**
 * @author weenhall
 */
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
