package io.github.justfoxx.teacup.v1.event;

import io.github.justfoxx.teacup.v1.registry.SetRegistry;
import io.github.justfoxx.teacup.v1.utils.ThrowingBiConsumer;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;

import java.util.Set;

public class EventKey <V, I> implements Event<V, I> {
    private final SetRegistry<V> registry;
    private final ThrowingBiConsumer<Set<V>, I> invoker;

    private EventKey(SetRegistry<V> registry, ThrowingBiConsumer<Set<V>, I> invoker) {
        this.registry = registry;
        this.invoker = invoker;
    }

    public static <V,T> EventKey<V,T> of(SetRegistry<V> registry, ThrowingBiConsumer<Set<V>,T> invoker) {
        return new EventKey<>(registry, invoker);
    }

    public static <V> EventKey<V,Void> of(SetRegistry<V> registry, ThrowingConsumer<Set<V>> invoker) {
        return EventKey.of(registry, ThrowingBiConsumer.convert(invoker));
    }

    public V onEvent(V value) {
        registry.add(value);
        return value;
    }

    public Set<V> getAll() {
        return registry.getAll();
    }

    @Override
    public void invoke(I value) {
        invoker.accept(getAll(),value);
    }
}
