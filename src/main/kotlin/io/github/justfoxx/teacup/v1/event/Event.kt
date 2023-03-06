package io.github.justfoxx.teacup.v1.event

/**
 * An event that can be invoked
 * @param <V> The type of the value
 * @param <I> The type of the invoker additional data (use Nothing if not needed)
</I></V> */
interface Event<V, I> {
    /**
     * Invoke the event
     * @param value Additional data to be passed to the event
     */
    fun invoke(value: I? = null)
}
