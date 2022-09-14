package com.ween.functionalinteface.biconsumer;

import java.util.Objects;

/**
 * @author weenhall
 */
@FunctionalInterface
public interface BiConsumer<T,U> {
    void accept(T arg0,U arg1);

    default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> arg0) {
        Objects.requireNonNull(arg0);
        return (arg1, arg2) -> {
            this.accept(arg1, arg2);
            arg0.accept(arg1, arg2);
        };
    }
}
