package io.github.justfoxx.teacup.v1.event

/**
 * A class that holds all the event functions
 */
internal object EventFunctions {
    fun <V> onIterator(
        entries: Set<(V) -> Unit>,
        data: V
    ) {
        for (entry in entries) {
            entry.invoke(data)
        }
    }
}
