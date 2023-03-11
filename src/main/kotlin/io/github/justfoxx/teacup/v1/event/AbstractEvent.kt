package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SortedRegistry

/**
 * An abstract base class for implementing an event with a set of values and an invoker.
 * @param V The type of the value passed to the event.
 * @param I The type of the invoker lambda used to trigger the event.
 */
abstract class AbstractEvent<V,I>(
    protected val registry: SortedRegistry<V,Event.Priority>,
    protected val invoker: (Set<V>) -> I
) : Event<V, I> {

    /**
     * Returns the invoker lambda used to trigger the event.
     * @return The invoker lambda.
     */
    override fun invoker(): I {
        return invoker(getAll())
    }

    /**
     * Called when the event is triggered with the given value.
     * @param value The value passed to the event.
     */
    abstract fun onEvent(value: V, priority: Event.Priority = Event.Priority.NORMAL)

    /**
     * Returns a set containing all values registered in the event.
     * @return The set of registered values.
     */
    protected abstract fun getAll(): Set<V>
}
