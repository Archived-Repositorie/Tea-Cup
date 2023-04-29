package io.github.justfoxx.teacup.v2.event.events

import io.github.justfoxx.teacup.v2.event.EventHandler
import io.github.justfoxx.teacup.v2.event.data.SingletonData
import io.github.justfoxx.teacup.v2.event.onIterator
import net.minecraft.server.MinecraftServer

object MinecraftServerEvents {
    @JvmStatic val ON_SERVER_STARTING = EventHandler.ofSingleton<SingletonData<MinecraftServer>> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_SERVER_STARTED = EventHandler.ofSingleton<SingletonData<MinecraftServer>> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_SERVER_STOPPING = EventHandler.ofSingleton<SingletonData<MinecraftServer>> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_SERVER_STOPPED = EventHandler.ofSingleton<SingletonData<MinecraftServer>> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_SERVER_TICKING = EventHandler.ofSingleton<SingletonData<MinecraftServer>> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_SERVER_TICKED = EventHandler.ofSingleton<SingletonData<MinecraftServer>> { data -> { info ->
        onIterator(data, info)
    }}
}