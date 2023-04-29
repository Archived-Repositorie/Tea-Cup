package io.github.justfoxx.teacup.v2.event.data

class Setter<Value>(private var value: Value) {
    private var original = value
    fun set(value: Value) {
        this.value = value
    }

    fun get(): Value = value

    fun getOriginal(): Value = original
}