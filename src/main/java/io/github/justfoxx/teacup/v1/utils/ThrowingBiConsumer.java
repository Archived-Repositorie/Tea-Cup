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

    /**
     * Shouldn't be used directly, use accept instead
     * @param a First input
     * @param b Second input
     * @throws Exception Any exception
     */
    void acceptThrows(A a, B b) throws Exception;

    /**
     * Converts a ThrowingConsumer to a ThrowingBiConsumer with a null second argument
     * @param consumer The consumer to convert
     * @param <A> The type of the consumer
     * @return A new ThrowingBiConsumer
     */
    static <A> ThrowingBiConsumer<A,Void> convert(ThrowingConsumer<A> consumer) {
        return (a, b) -> consumer.acceptThrows(a);
    }
}
