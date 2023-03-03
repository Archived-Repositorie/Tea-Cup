package io.github.justfoxx.teacup.v1.event.data;

import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;

/**
 * Data for the {@link io.github.justfoxx.teacup.v1.event.Events#ON_ITEM_USE} event
 * @param player The player that used the item
 * @param itemStack The item that was used
 * @param hand The hand that the item was used with
 */
public record OnItemUseData(ServerPlayerEntity player, ItemStack itemStack, Hand hand){}
