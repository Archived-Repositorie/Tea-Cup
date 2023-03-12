package io.github.justfoxx.teacup.v1.event

import net.minecraft.item.ItemStack
import net.minecraft.network.ClientConnection
import net.minecraft.network.NetworkState
import net.minecraft.network.PacketCallbacks
import net.minecraft.network.packet.Packet
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

data class MessageData(
    val message: Text,
    val overlay: Boolean,
    val player: ServerPlayerEntity,
    val info: CallbackInfo,
)

data class InternalPacketData(
    val packet: Packet<*>,
    val callback: PacketCallbacks?,
    val packetState: NetworkState,
    val currentState: NetworkState,
    val clientConnectionHandler: ClientConnection,
    val info: CallbackInfo,
)

data class OnItemUseData(
    val player: ServerPlayerEntity,
    val itemStack: ItemStack,
    val hand: Hand,
    val itemUseResult: CallbackInfoReturnable<ActionResult>,
)