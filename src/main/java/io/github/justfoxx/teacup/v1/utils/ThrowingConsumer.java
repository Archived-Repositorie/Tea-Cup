package io.github.justfoxx.teacup.v1.utils;


import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T> {

    @Override
    default void accept(final T elem) {
        try {
            acceptThrows(elem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Shouldn't be used directly, use accept instead
     * @param elem Element
     * @throws Exception Any exception
     */
    void acceptThrows(T elem) throws Exception;
}
