package io.github.justfoxx.teacup.v1.event

interface SortedEvent<V,I> : Event<V,I> {
    fun onEvent(value: V, priority: Priority = Priority.NORMAL)

    @Suppress("unused")
    enum class Priority {
        HIGHEST,
        HIGH,
        NORMAL,
        LOW,
        LOWEST
    }
}
