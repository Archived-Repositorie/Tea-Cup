package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import io.github.justfoxx.teacup.v1.registry.SetRegistry
import net.minecraft.entity.Entity

/**
 * A singleton object that contains event keys for all supported events.
 */
object Events {

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