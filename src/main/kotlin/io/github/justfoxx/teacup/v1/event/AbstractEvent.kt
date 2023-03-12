package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SortedRegistry

/**
 * An abstract base class for implementing an event with a set of values and an invoker.
 * @param V The type of the value passed to the event.
 * @param I The type of the invoker lambda used to trigger the event.
 */
abstract class AbstractEvent<V,I>(
    protected val registry: SortedRegistry<V,Event.Priority>,
    protected val invoker: (List<V>) -> I
) : Event<V, I> {
    override fun invoker(): I {
        return invoker(getAll())
    }

    abstract fun onEvent(value: V, priority: Event.Priority = Event.Priority.NORMAL)

    protected abstract fun getAll(): List<V>
}
