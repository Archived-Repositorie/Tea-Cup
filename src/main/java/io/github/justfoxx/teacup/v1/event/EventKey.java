package io.github.justfoxx.teacup.v1.event;

import com.google.common.collect.ImmutableSet;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;

import java.util.Set;

public class EventKey <V,T> implements Event<V,T> {
    private final Set<V> registry;
    private final ThrowingConsumer<T> invoker;

    public EventKey(Set<V> registry, ThrowingConsumer<T> invoker) {
        this.registry = registry;
        this.invoker = invoker;
    }

    public V onEvent(V value) {
        registry.add(value);
        return value;
    }

    public void invoke(T value) {
        invoker.accept(value);
    }

    public ImmutableSet<V> getAll() {
        return ImmutableSet.copyOf(registry);
    }
}
