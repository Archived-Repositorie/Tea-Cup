package io.github.justfoxx.teacup.v1.event

/**
 * An event that can be invoked.
 * @param V The type of the value passed to the event.
 * @param I The type of the invoker lambda.
 */
interface Event<V, I> {

    fun invoker(): I

    enum class Priority {
        HIGHEST,
        HIGH,
        NORMAL,
        LOW,
        LOWEST
    }
}
