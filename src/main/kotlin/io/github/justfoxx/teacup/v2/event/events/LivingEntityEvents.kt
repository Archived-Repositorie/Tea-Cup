package io.github.justfoxx.teacup.v2.event.events

import io.github.justfoxx.teacup.v2.event.EventHandler
import io.github.justfoxx.teacup.v2.event.data.SingletonData
import io.github.justfoxx.teacup.v2.event.onIterator
import net.minecraft.entity.LivingEntity

object LivingEntityEvents {
    @JvmStatic val ON_ENTITY_DYING = EventHandler.ofSingleton<SingletonData<LivingEntity>> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_ENTITY_DIED = EventHandler.ofSingleton<SingletonData<LivingEntity>> { data -> { info ->
        onIterator(data, info)
    }}
}