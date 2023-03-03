package io.github.justfoxx.teacup.v1.utils;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface ThrowingBiConsumer <A, B> extends BiConsumer<A, B> {
    @Override
    default void accept(final A a, final B b) {
        try {
            acceptThrows(a, b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void acceptThrows(A a, B b) throws Exception;

    static <T> ThrowingBiConsumer<T,Void> convert(ThrowingConsumer<T> consumer) {
        return (a, b) -> consumer.accept(a);
    }
}
