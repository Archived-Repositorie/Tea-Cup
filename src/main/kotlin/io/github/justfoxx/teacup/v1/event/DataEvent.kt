package io.github.justfoxx.teacup.v1.event

interface DataEvent<Value,Data,Invoker> : Event<Value,Invoker> {
    fun onEvent(value: Value, data: Data)
}