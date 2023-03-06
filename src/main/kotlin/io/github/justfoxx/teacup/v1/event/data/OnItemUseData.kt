package io.github.justfoxx.teacup.v1.event.data

import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand

/**
 * Data for the [io.github.justfoxx.teacup.v1.event.Events.ON_ITEM_USE] event
 * @param player The player that used the item
 * @param itemStack The item that was used
 * @param hand The hand that the item was used with
 */
data class OnItemUseData(val player: ServerPlayerEntity, val itemStack: ItemStack, val hand: Hand)