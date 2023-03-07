package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SetRegistry


/**
 * An implementation of Event that should be used when registry values don't need additional data.
 *
 * @param V The value type.
 * @param I The invoker additional type (if not present, use Nothing).
 */
class EventKey<V, I> constructor(
    private val registry: SetRegistry<V>,
    private val invoker: (Set<V>, I?) -> Unit
) : Event<V, I> {

    /**
     * Registers a new value in the event registry.
     *
     * @param value The value to register.
     */
    fun onEvent(value: V) {
        registry.add(value)
    }

    /**
     * Returns all the values registered in the event registry.
     * This method shouldn't be used outside the event system.
     *
     * @return All registered values.
     */
    private val all: Set<V>
        get() = registry.all

    /**
     * Invokes the event and passes the given additional value to the invoker.
     * This method shouldn't be used outside the event system.
     *
     * @param value The value to pass to the invoker.
     */
    override operator fun invoke(value: I?) {
        invoker.invoke(all, value)
    }
}