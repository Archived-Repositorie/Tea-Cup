package io.github.justfoxx.teacup.v2.event.events

import io.github.justfoxx.teacup.v2.event.EventHandler
import io.github.justfoxx.teacup.v2.event.data.SingletonData
import io.github.justfoxx.teacup.v2.event.onIterator
import net.minecraft.entity.Entity

object EntityEvents {
    @JvmStatic val ON_ENTITY_TICKING = EventHandler.ofSingleton<SingletonData<Entity>> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_ENTITY_TICKED = EventHandler.ofSingleton<SingletonData<Entity>> { data -> { info ->
        onIterator(data, info)
    }}

}