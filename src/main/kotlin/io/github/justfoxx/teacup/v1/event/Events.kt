package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import io.github.justfoxx.teacup.v1.registry.SetRegistry
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.server.MinecraftServer

/**
 * A singleton object that contains event keys for all supported events.
 */
object Events {

    /**
     * Event key for when the server is starting up.
     * This event is triggered when the server is in the process of starting up.
     */
    @JvmStatic val ON_SERVER_STARTING: SingleEventKey<(MinecraftServer) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when the server has started up.
     * This event is triggered when the server has finished starting up and is ready to accept connections.
     */
    @JvmStatic val ON_SERVER_STARTED: SingleEventKey<(MinecraftServer) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when the server is stopping.
     * This event is triggered when the server is in the process of shutting down.
     */
    @JvmStatic val ON_SERVER_STOPPING: SingleEventKey<(MinecraftServer) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when the server has stopped.
     * This event is triggered when the server has completely shut down.
     */
    @JvmStatic val ON_SERVER_STOPPED: SingleEventKey<(MinecraftServer) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when the server is ticking.
     * This event is triggered every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKING: SingleEventKey<(MinecraftServer) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when the server has finished ticking.
     * This event is triggered after every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKED: SingleEventKey<(MinecraftServer) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when a player starts using an item.
     * This event is triggered when the player starts the action of using an item.
     */
    @JvmStatic val ON_ITEM_USING: SingleEventKey<(OnItemUseData) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when a player finishes using an item.
     * This event is triggered when the player finishes the action of using an item.
     */
    @JvmStatic val ON_ITEM_USED: SingleEventKey<(OnItemUseData) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when an entity starts ticking.
     * This event is triggered when an entity starts updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKING: SingleEventKey<(Entity) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when an entity finishes ticking.
     * This event is triggered when an entity has finished updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKED: SingleEventKey<(Entity) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when an entity is about to die.
     * This event is triggered when an entity is about to die.
     */
    @JvmStatic val ON_ENTITY_DYING: SingleEventKey<(LivingEntity) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}

    /**
     * Event key for when an entity has died.
     * This event is triggered when an entity has died.
     */
    @JvmStatic val ON_ENTITY_DIED: SingleEventKey<(LivingEntity) -> Unit> =
        SingleEventKey(SetRegistry()) { data -> { info ->
            EventFunctions.onIterator(data, info)
        }}
}