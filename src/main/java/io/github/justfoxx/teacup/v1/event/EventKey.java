package io.github.justfoxx.teacup.v1.event;

import io.github.justfoxx.teacup.v1.registry.SetRegistry;
import io.github.justfoxx.teacup.v1.utils.ThrowingBiConsumer;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;

import java.util.Set;

/**
 * Should be used only when registry values don't need additional data
 * @param <V> The value type
 * @param <I> The invoker additional type (if not present, use Void)
 */
public class EventKey <V, I> implements Event<V, I> {
    private final SetRegistry<V> registry;
    private final ThrowingBiConsumer<Set<V>, I> invoker;

    private EventKey(SetRegistry<V> registry, ThrowingBiConsumer<Set<V>, I> invoker) {
        this.registry = registry;
        this.invoker = invoker;
    }

    /**
     * Should be used only when the invoker needs additional data
     * @param registry The registry to use
     * @param invoker The invoker to use
     * @param <V> The value type
     * @param <T> The invoker additional type
     * @return A new EventKey
     */
    public static <V,T> EventKey<V,T> of(SetRegistry<V> registry, ThrowingBiConsumer<Set<V>,T> invoker) {
        return new EventKey<>(registry, invoker);
    }

    /**
     * Should be used only when the invoker doesn't need additional data
     * @param registry The registry to use
     * @param invoker The invoker to use
     * @param <V> The value type
     * @return A new EventKey
     */
    public static <V> EventKey<V,Void> of(SetRegistry<V> registry, ThrowingConsumer<Set<V>> invoker) {
        return EventKey.of(registry, ThrowingBiConsumer.convert(invoker));
    }

    /**
     * Should be used in PreLaunchEntrypoint
     * @param value The value to register
     */
    public void onEvent(V value) {
        registry.add(value);
    }

    /**
     * Shouldn't be used outside the event system
     * @return All registered values
     */
    public Set<V> getAll() {
        return registry.getAll();
    }

    /**
     * Shouldn't be used outside the event system
     * @param value The value to pass to the invoker
     */
    @Override
    public void invoke(I value) {
        invoker.accept(getAll(),value);
    }
}
