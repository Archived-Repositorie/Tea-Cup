package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SortedRegistry
import io.github.justfoxx.teacup.v1.utils.toSet

/**
 * An implementation of the Event interface that can be used when both registry and invoker are of the same type.
 * @param V The type of the value passed to the event.
 */
class SingletonEvent<V>(
    registry: SortedRegistry<V, Event.Priority> = SortedRegistry(),
    invoker: (Set<V>) -> V
) : AbstractEvent<V, V>(registry, invoker) {

    /**
     * Returns a set containing all values registered in the event.
     * @return The set of registered values.
     */
    override fun getAll(): Set<V> {
        return registry.all.toSet()
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
    override fun onEvent(value: V, priority: Event.Priority) {
        registry.register(value, priority)
    }
}
