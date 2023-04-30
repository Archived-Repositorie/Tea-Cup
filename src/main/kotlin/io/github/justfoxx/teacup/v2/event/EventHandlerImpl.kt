package io.github.justfoxx.teacup.v2.event

import io.github.justfoxx.teacup.v2.utils.sort.Priority
import io.github.justfoxx.teacup.v2.utils.sort.SortedList
import kotlin.reflect.KFunction1

class EventHandlerImpl<Value, Invoker>(private val invoker: (Iterable<KFunction1<Value,Unit>>) -> Invoker)
    : EventHandler<Value, Invoker> {
    private val values = SortedList<KFunction1<Value,Unit>, Priority>()

    override fun invoker(): Invoker = invoker(getAll())

    override fun getAll(): Iterable<KFunction1<Value,Unit>> = values.iterator()

    override fun register(value: KFunction1<Value,Unit>) {
        val event = value.annotations.find { it is Subscriber } as Subscriber?
            ?: Subscriber(Priority.NORMAL)

        values.add(value, event.priority)
    }


}