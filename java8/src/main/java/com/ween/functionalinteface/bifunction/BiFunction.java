package com.ween.functionalinteface.bifunction;

import com.ween.functionalinteface.function.Function;

import java.util.Objects;

/**
 * @author weenhall
 */
@FunctionalInterface
public interface BiFunction<T,U,R> {
    R apply(T arg0, U arg1);

    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> arg0) {
        Objects.requireNonNull(arg0);
        return (arg1, arg2) -> {
            return arg0.apply(this.apply(arg1, arg2));
        };
    }
}
