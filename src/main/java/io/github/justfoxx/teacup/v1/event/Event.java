package io.github.justfoxx.teacup.v1.event;

/**
 * An event that can be invoked
 * @param <V> The type of the value
 * @param <I> The type of the invoker additional data
 */
public interface Event <V,I> {
    void invoke(I value);

    /**
     * Use it only when generic type I is Void
     */
    default void invoke() {
        invoke(null);
    }
}
