package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.MapRegistry

/**
 * A class used for creating event keys that require additional data to be passed to the event invoker.
 * @param <V> The type of the value stored in the registry.
 * @param <D> The type of the additional data required by the event invoker.
 * @param <I> The type of additional data required by the event invoker (if not present, use Void).
</I></D></V> */
class DataEventKey<V, D, I> constructor(
    registry: MapRegistry<V, D>,
    invoker: (Set<Map.Entry<V, D>>, I?) -> Unit
) : Event<V, I> {
    private val registry: MapRegistry<V, D>
    private val invoker: (Set<Map.Entry<V, D>>, I?) -> Unit

    init {
        this.registry = registry
        this.invoker = invoker
    }

    /**
     * Registers a new value with the specified data for this event.
     * @param value The value to register.
     * @param data The data to pass to the event invoker.
     */
    fun onEvent(value: V, data: D) {
        registry.add(value, data)
    }

    val all: Set<Map.Entry<V, D>>
        /**
         * Returns a set containing all registered values and their associated data.
         * @return A set containing all registered values and their associated data.
         */
        get() = registry.all

    /**
     * Invokes the event using the specified additional data.
     * @param value The additional data to pass to the event invoker.
     */
    override operator fun invoke(value: I?) {
        invoker.invoke(all, value)
    }
}