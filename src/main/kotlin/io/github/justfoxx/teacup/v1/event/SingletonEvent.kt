package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SortedRegistry

/**
 * An implementation of the Event interface that can be used when both registry and invoker are of the same type.
 * @param V The type of the value passed to the event.
 */
class SingletonEvent<V>(
    private val registry: SortedRegistry<V, SortedEvent.Priority> = SortedRegistry(),
    private val invoker: (List<V>) -> V
) : SortedEvent<V, V> {

    /**
     * Returns a set containing all values registered in the event.
     * @return The set of registered values.
     */
    override fun getAll(): List<V> {
        return registry.all
    }

    /**
     * Returns the value that will be passed to the invoker lambda when the event is triggered.
     * @return The value passed to the invoker lambda.
     */
    override fun invoker(): V {
        return invoker.invoke(getAll())
    }

    /**
     * Called when the event is triggered with the given value.
     * @param value The value passed to the event.
     */
    override fun onEvent(value: V, priority: SortedEvent.Priority) {
        registry.register(value, priority)
    }
}
