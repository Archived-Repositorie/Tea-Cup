package io.github.justfoxx.teacup.v2.event.events

import io.github.justfoxx.teacup.v2.event.EventHandler
import io.github.justfoxx.teacup.v2.event.data.OnItemUseData
import io.github.justfoxx.teacup.v2.event.onIterator

object ItemEvents {
    @JvmStatic val ON_ITEM_USING = EventHandler.ofSingleton<OnItemUseData> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_ITEM_USED = EventHandler.ofSingleton<OnItemUseData> { data -> { info ->
        onIterator(data, info)
    }}
}