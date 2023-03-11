package io.github.justfoxx.teacup.v1.event

/**
 * An event that can be invoked.
 * @param V The type of the value passed to the event.
 * @param I The type of the invoker lambda.
 */
interface Event<V, I> {
    /**
     * Returns the invoker object.
     * @return The invoker object.
     */
    fun invoker(): I

    enum class Priority {
        LOWEST,
        LOW,
        NORMAL,
        HIGH,
        HIGHEST
    }
}
