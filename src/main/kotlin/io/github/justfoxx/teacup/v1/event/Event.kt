package io.github.justfoxx.teacup.v1.event

/**
 * An event that can be invoked
 * @param <V> The type of the value
 * @param <I> The type of the invoker additional data
</I></V> */
interface Event<V, I> {
    /**
     * Use it only when generic type I is Void
     */
    fun invoke(value: I? = null)
}