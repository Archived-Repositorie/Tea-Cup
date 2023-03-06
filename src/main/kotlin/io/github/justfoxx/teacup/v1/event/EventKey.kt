package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SetRegistry

/**
 * Should be used only when registry values don't need additional data
 * @param <V> The value type
 * @param <I> The invoker additional type (if not present, use Void)
</I></V> */
class EventKey<V, I> constructor(
    private val registry: SetRegistry<V>,
    private val invoker: (Set<V>, I?) -> Unit
) : Event<V, I> {

    /**
     * Should be used in PreLaunchEntrypoint
     * @param value The value to register
     */
    fun onEvent(value: V) {
        registry.add(value)
    }

    val all: Set<V>
        /**
         * Shouldn't be used outside the event system
         * @return All registered values
         */
        get() = registry.all

    /**
     * Shouldn't be used outside the event system
     * @param value The value to pass to the invoker
     */
    override operator fun invoke(value: I?) {
        invoker.invoke(all, value)
    }
}