package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import io.github.justfoxx.teacup.v1.registry.SetRegistry
import net.minecraft.entity.Entity

/**
 * A class that holds all the events
 */
object Events {
    /**
     * An event that is called when a player uses an item
     */
    val ON_ITEM_USING: EventKey<(OnItemUseData) -> Unit, OnItemUseData> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onItemUse(data, info!!)
        }

    val ON_ITEM_USED: EventKey<(OnItemUseData) -> Unit, OnItemUseData> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onItemUse(data, info!!)
        }

    val ON_ENTITY_TICKING: EventKey<(Entity) -> Unit, Entity> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onEntityTick(data, info!!)
        }

    val ON_ENTITY_TICKED: EventKey<(Entity) -> Unit, Entity> =
        EventKey(SetRegistry()) { data, info ->
            EventFunctions.onEntityTick(data, info!!)
        }
}