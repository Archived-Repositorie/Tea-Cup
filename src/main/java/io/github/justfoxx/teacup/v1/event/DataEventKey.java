package io.github.justfoxx.teacup.v1.event;

import io.github.justfoxx.teacup.v1.registry.MapRegistry;
import io.github.justfoxx.teacup.v1.utils.ThrowingBiConsumer;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;

import java.util.Map;
import java.util.Set;

/**
 * Should be used only when registry values need additional data
 * @param <V> The value type
 * @param <D> The data type
 * @param <I> The invoker additional type (if not present, use Void)
 */
public class DataEventKey <V,D,I> implements Event<V, I> {
    private final MapRegistry<V,D> registry;
    private final ThrowingBiConsumer<Set<Map.Entry<V,D>>,I> invoker;

    private DataEventKey(MapRegistry<V,D> registry, ThrowingBiConsumer<Set<Map.Entry<V,D>>,I> invoker) {
        this.registry = registry;
        this.invoker = invoker;
    }

    /**
     * Should be used only when the invoker needs additional data
     * @param registry The registry to use
     * @param invoker The invoker to use
     * @param <V> The value type
     * @param <D> The data type
     * @param <T> The invoker additional type
     * @return A new DataEventKey
     */
    public static <V,D,T> DataEventKey<V,D,T> of(MapRegistry<V,D> registry, ThrowingBiConsumer<Set<Map.Entry<V,D>>,T> invoker) {
        return new DataEventKey<>(registry, invoker);
    }

    /**
     * Should be used only when the invoker doesn't need additional data
     * @param registry The registry to use
     * @param invoker The invoker to use
     * @param <V> The value type
     * @param <D> The data type
     * @return A new DataEventKey
     */
    public static <V,D> DataEventKey<V,D,Void> of(MapRegistry<V,D> registry, ThrowingConsumer<Set<Map.Entry<V,D>>> invoker) {
        return of(registry, ThrowingBiConsumer.convert(invoker));
    }

    /**
     * Should be used in PreLaunchEntrypoint
     * @param value The value to register
     * @param data The data to pass to the invoker
     */
    public void onEvent(V value, D data) {
        registry.add(value, data);
    }

    /**
     * Shouldn't be used outside the event system
     * @return A set of all registered values with their data
     */
    public Set<Map.Entry<V,D>> getAll() {
        return registry.getAll();
    }

    /**
     * Shouldn't be used outside the event system
     * @param data The data to pass to the invoker
     */
    @Override
    public void invoke(I data) {
        invoker.accept(getAll(),data);
    }
}
