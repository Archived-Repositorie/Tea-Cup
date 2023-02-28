package io.github.justfoxx.teacup.v1.event;

import com.google.common.collect.ImmutableSet;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;
import io.github.justfoxx.teacup.v1.utils.tuples.Tuple;

import java.util.Map;
import java.util.function.Consumer;

public class DataEventKey <V,D extends Tuple<?>,T> implements Event<V,T> {
    private final Map<V,D> registry;
    private final Consumer<T> invoker;

    public DataEventKey(Map<V,D> registry, ThrowingConsumer<T> invoker) {
        this.registry = registry;
        this.invoker = invoker;
    }

    public Map.Entry<V,D> onEvent(V value, D data) {
        registry.putIfAbsent(value, data);
        return Map.entry(value, data);
    }

    public ImmutableSet<Map.Entry<V,D>> getAll() {
        return ImmutableSet.copyOf(registry.entrySet());
    }

    @Override
    public void invoke(T value) {
        invoker.accept(value);
    }

}
