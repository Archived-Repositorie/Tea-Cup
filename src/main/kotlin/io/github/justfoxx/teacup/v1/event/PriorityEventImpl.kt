package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SortedRegistry
import io.github.justfoxx.teacup.v1.utils.Priority

/**
 * An implementation of the Event interface that can be used when both registry and invoker are of the same type.
 * @param Value The type of the value passed to the event.
 */
class PriorityEventImpl<Value, Invoker>(
    private val invoker: (List<Value>) -> Invoker
) : PriorityEvent<Value, Invoker> {
    private val registry: SortedRegistry<Value, Priority> = SortedRegistry()

    /**
     * Returns a set containing all values registered in the event.
     * @return The set of registered values.
     */
    override fun getAll(): List<Value> = registry.getAll()

    /**
     * Returns the value that will be passed to the invoker lambda when the event is triggered.
     * @return The value passed to the invoker lambda.
     */
    override fun invoker(): Invoker = invoker(getAll())

    /**
     * Called when the event is triggered with the given value.
     * @param value The value passed to the event.
     */
    override fun onEvent(value: Value, data: Priority) {
        registry.register(value, data)
    }
}
