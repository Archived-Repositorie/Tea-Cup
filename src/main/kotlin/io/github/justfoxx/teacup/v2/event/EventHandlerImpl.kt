package io.github.justfoxx.teacup.v2.event

import io.github.justfoxx.teacup.v2.utils.sort.Priority
import io.github.justfoxx.teacup.v2.utils.sort.SortedList
import kotlin.reflect.KFunction1

class EventHandlerImpl<Value : KFunction1<*,Unit>, Invoker>(private val invoker: (Iterable<Value>) -> Invoker)
    : EventHandler<Value, Invoker> {
    private val values = SortedList<Value, Priority>()

    override fun invoker(): Invoker = invoker(getAll())

    override fun getAll(): Iterable<Value> = values.iterator()

    override fun register(value: Value) {
        val event = value.annotations.find { it is Subscriber } as Subscriber?
            ?: Subscriber(Priority.NORMAL)

        values.add(value, event.priority)
    }
}