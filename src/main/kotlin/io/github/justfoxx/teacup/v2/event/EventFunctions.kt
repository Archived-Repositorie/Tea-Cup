package io.github.justfoxx.teacup.v2.event

import io.github.justfoxx.teacup.v2.event.data.MessageTextData
import io.github.justfoxx.teacup.v2.event.data.MutableSingletonData
import kotlin.reflect.KFunction1


internal fun <Value> onIterator(
    entries: Iterable<KFunction1<Value,Unit>>,
    data: Value
) {
    for (entry in entries) {
        entry.call(data)
    }
}

internal fun <Value> onMutableIterator(
    entries: Iterable<KFunction1<MutableSingletonData<Value>,Unit>>,
    data: MutableSingletonData<Value>
) {
    for (entry in entries) {
        entry.call(data, Unit)
    }
}

internal fun onMessageTextIterator(
    entries: Iterable<KFunction1<MessageTextData, Unit>>,
    data: MessageTextData
) {
    for (entry in entries) {
        entry.call(data)
    }
}

