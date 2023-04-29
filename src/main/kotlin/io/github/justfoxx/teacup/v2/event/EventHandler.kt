package io.github.justfoxx.teacup.v2.event

import kotlin.reflect.KFunction1

/**
 * An event that can be invoked.
 * @param Value The type of the value passed to the event.
 * @param Invoker The type of the invoker lambda.
 */
interface EventHandler<Value : KFunction1<*,Unit>, Invoker> {
    fun invoker(): Invoker
    fun getAll(): Iterable<Value>
    fun register(value: Value)

    companion object {
        fun <Value> ofSingleton(invoker: (Iterable<KFunction1<Value,Unit>>) -> (Value) -> Unit): EventHandler<KFunction1<Value,Unit>, (Value) -> Unit> = EventHandlerImpl(invoker)
    }
}
