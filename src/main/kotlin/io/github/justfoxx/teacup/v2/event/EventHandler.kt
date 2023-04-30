package io.github.justfoxx.teacup.v2.event

import kotlin.reflect.KFunction1
import kotlin.reflect.full.functions
import kotlin.reflect.jvm.isAccessible

/**
 * An event that can be invoked.
 * @param Value The type of the value passed to the event.
 * @param Invoker The type of the invoker lambda.
 */
interface EventHandler<Value, Invoker> {
    fun invoker(): Invoker
    fun getAll(): Iterable<KFunction1<Value, Unit>>
    fun register(value: KFunction1<Value, Unit>)

    /**
     * Register helper.
     * Uses reflection to convert java method to kotlin function and registers it.
     * It is unsafe, requires to method be **static**
     * and must have **one** parameter which is [Value] and return value [Unit].
     * Before using it, read documentation of library.
     * @param clazz The class of function
     * @param methodName The name of method
     */
    fun registerHelper(clazz: Class<*>, methodName: String) {
        val classKotlin = clazz.kotlin
        val kfunction = classKotlin.functions.stream().filter { it.name == methodName }.findFirst().get()
        if(!kfunction.isAccessible) kfunction.isAccessible = true
        register(kfunction as KFunction1<Value, Unit>)
    }

    companion object {
        fun <Value> ofSingleton(invoker: (Iterable<KFunction1<Value,Unit>>) -> (Value) -> Unit): EventHandler<Value, (Value) -> Unit> = EventHandlerImpl(invoker)
    }
}
