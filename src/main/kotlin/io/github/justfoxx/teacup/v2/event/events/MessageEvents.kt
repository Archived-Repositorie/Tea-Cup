package io.github.justfoxx.teacup.v2.event.events

import io.github.justfoxx.teacup.v2.event.EventHandler
import io.github.justfoxx.teacup.v2.event.data.MessageData
import io.github.justfoxx.teacup.v2.event.data.MessageTextData
import io.github.justfoxx.teacup.v2.event.onIterator
import io.github.justfoxx.teacup.v2.event.onMessageTextIterator

object MessageEvents {
    @JvmStatic val ON_MESSAGE_SEND = EventHandler.ofSingleton<MessageData> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_MESSAGE_MODIFY = EventHandler.ofSingleton<MessageTextData> { data -> { info ->
        onMessageTextIterator(data, info)
    }}
}