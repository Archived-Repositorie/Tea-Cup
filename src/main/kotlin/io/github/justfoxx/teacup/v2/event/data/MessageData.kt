package io.github.justfoxx.teacup.v2.event.data

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

data class MessageData(
    val message: Text,
    val overlay: Boolean,
    val player: ServerPlayerEntity,
    val info: CallbackInfo,
)
