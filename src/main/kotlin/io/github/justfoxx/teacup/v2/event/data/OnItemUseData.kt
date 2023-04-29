package io.github.justfoxx.teacup.v2.event.data

import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

data class OnItemUseData(
    val player: ServerPlayerEntity,
    val itemStack: ItemStack,
    val hand: Hand,
    val itemUseResult: CallbackInfoReturnable<ActionResult>,
)
