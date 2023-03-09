package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import io.github.justfoxx.teacup.v1.registry.SetRegistry
import net.minecraft.entity.Entity
import net.minecraft.server.MinecraftServer

/**
 * A singleton object that contains event keys for all supported events.
 */
object Events {

    /**
     * Event key for when the server is starting up.
     * This event is triggered when the server is in the process of starting up.
     */
    @JvmStatic val ON_SERVER_STARTING: Event<(MinecraftServer) -> Unit, MinecraftServer> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onServer(data, info!!)
        }

    /**
     * Event key for when the server has started up.
     * This event is triggered when the server has finished starting up and is ready to accept connections.
     */
    @JvmStatic val ON_SERVER_STARTED: Event<(MinecraftServer) -> Unit, MinecraftServer> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onServer(data, info!!)
        }

    /**
     * Event key for when the server is stopping.
     * This event is triggered when the server is in the process of shutting down.
     */
    @JvmStatic val ON_SERVER_STOPPING: Event<(MinecraftServer) -> Unit, MinecraftServer> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onServer(data, info!!)
        }

    /**
     * Event key for when the server has stopped.
     * This event is triggered when the server has completely shut down.
     */
    @JvmStatic val ON_SERVER_STOPPED: Event<(MinecraftServer) -> Unit, MinecraftServer> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onServer(data, info!!)
        }

    /**
     * Event key for when the server is ticking.
     * This event is triggered every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKING: Event<(MinecraftServer) -> Unit, MinecraftServer> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onServer(data, info!!)
        }

    /**
     * Event key for when the server has finished ticking.
     * This event is triggered after every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKED: Event<(MinecraftServer) -> Unit, MinecraftServer> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onServer(data, info!!)
        }

    /**
     * Event key for when a player starts using an item.
     * This event is triggered when the player starts the action of using an item.
     */
    @JvmStatic val ON_ITEM_USING: EventKey<(OnItemUseData) -> Unit, OnItemUseData> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onItemUse(data, info!!)
        }

    /**
     * Event key for when a player finishes using an item.
     * This event is triggered when the player finishes the action of using an item.
     */
    @JvmStatic val ON_ITEM_USED: EventKey<(OnItemUseData) -> Unit, OnItemUseData> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onItemUse(data, info!!)
        }

    /**
     * Event key for when an entity starts ticking.
     * This event is triggered when an entity starts updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKING: EventKey<(Entity) -> Unit, Entity> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onEntityTick(data, info!!)
        }

    /**
     * Event key for when an entity finishes ticking.
     * This event is triggered when an entity has finished updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKED: EventKey<(Entity) -> Unit, Entity> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onEntityTick(data, info!!)
        }
}