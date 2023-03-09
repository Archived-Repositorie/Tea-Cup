package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import net.minecraft.entity.Entity
import net.minecraft.server.MinecraftServer

/**
 * A class that holds all the event functions
 */
internal object EventFunctions {
    /**
     * The function that gets called when a player uses an item
     */
    fun onItemUse(
        entries: Set<(OnItemUseData) -> Unit>,
        data: OnItemUseData
    ) {
        for (value in entries) {
            value.invoke(data)
        }
    }

    fun onEntityTick(
        entries: Set<(Entity) -> Unit>,
        data: Entity
    ) {
        for (value in entries) {
            value.invoke(data)
        }
    }

    fun onServer(
        entries: Set<(MinecraftServer) -> Unit>,
        data: MinecraftServer
    ) {
        for (entry in entries) {
            entry.invoke(data)
        }
    }
}
