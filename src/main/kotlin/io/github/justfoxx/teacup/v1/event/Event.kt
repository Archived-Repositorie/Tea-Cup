package io.github.justfoxx.teacup.v1.event

/**
 * An event that can be invoked.
 * @param Value The type of the value passed to the event.
 * @param Invoker The type of the invoker lambda.
 */
interface Event<Value, Invoker> {
    fun invoker(): Invoker
    fun getAll(): Collection<Value>
}
