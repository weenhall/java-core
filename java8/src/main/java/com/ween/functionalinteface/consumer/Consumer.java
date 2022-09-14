package com.ween.functionalinteface.consumer;

import java.util.Objects;

/**
 * @author weenhall
 */
@FunctionalInterface
public interface Consumer<T> {
    void accept(T arg0);

    default Consumer<T> andThen(Consumer<? super T> arg0) {
        Objects.requireNonNull(arg0);
        return (arg1) -> {
            this.accept(arg1);
            arg0.accept(arg1);
        };
    }
}
