package io.github.justfoxx.teacup.v1.event.data

import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand

/**
 * Data class for the [io.github.justfoxx.teacup.v1.event.Events.ON_ITEM_USE] event.
 * Contains information about the player who used the item, the item that was used, and the hand used to use it.
 *
 * @property player The player who used the item.
 * @property itemStack The item that was used.
 * @property hand The hand used to use the item.
 */
data class OnItemUseData(
    val player: ServerPlayerEntity,
    val itemStack: ItemStack,
    val hand: Hand
)
