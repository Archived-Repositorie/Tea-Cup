package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.utils.Priority

interface PriorityEvent<Value,Invoker> : DataEvent<Value,Priority,Invoker> {
    override fun onEvent(value: Value, data: Priority)

    companion object {
        fun <Value> ofSingleton(invoker: (List<Value>) -> Value): PriorityEvent<Value,Value> = PriorityEventImpl(invoker)
    }
}
