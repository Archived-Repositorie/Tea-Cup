package io.github.justfoxx.teacup.v1.event;

import io.github.justfoxx.teacup.v1.registry.MapRegistry;
import io.github.justfoxx.teacup.v1.utils.ThrowingBiConsumer;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;
import io.github.justfoxx.teacup.v1.utils.tuples.Tuple;

import java.util.Map;
import java.util.Set;

public class DataEventKey <V,D extends Tuple<?>, I> implements Event<V, I> {
    private final MapRegistry<V,D> registry;
    private final ThrowingBiConsumer<Set<Map.Entry<V,D>>,I> invoker;

    private DataEventKey(MapRegistry<V,D> registry, ThrowingBiConsumer<Set<Map.Entry<V,D>>,I> invoker) {
        this.registry = registry;
        this.invoker = invoker;
    }

    public static <V,D extends Tuple<?>,T> DataEventKey<V,D,T> of(MapRegistry<V,D> registry, ThrowingBiConsumer<Set<Map.Entry<V,D>>,T> invoker) {
        return new DataEventKey<>(registry, invoker);
    }

    public static <V,D extends Tuple<?>> DataEventKey<V,D,Void> of(MapRegistry<V,D> registry, ThrowingConsumer<Set<Map.Entry<V,D>>> invoker) {
        return DataEventKey.of(registry, ThrowingBiConsumer.convert(invoker));
    }

    public void onEvent(V value, D data) {
        registry.add(value, data);
    }

    public Set<Map.Entry<V,D>> getAll() {
        return registry.getAll();
    }

    @Override
    public void invoke(I data) {
        invoker.accept(getAll(),data);
    }
}
