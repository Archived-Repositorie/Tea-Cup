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

    void acceptThrows(T elem) throws Exception;

    static <T> ThrowingConsumer<T> getDefault() {
        return c -> {};
    }
}
