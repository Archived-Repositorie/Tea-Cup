package io.github.justfoxx.teacup.v1.event;

public interface Event <V,I> {
    void invoke(I value);
    default void invoke() {
        invoke(null);
    }
}
