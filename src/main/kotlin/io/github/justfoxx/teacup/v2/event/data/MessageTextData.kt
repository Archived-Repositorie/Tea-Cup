package io.github.justfoxx.teacup.v2.event.data

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text

data class MessageTextData (
    val text: Setter<Text>,
    val player: ServerPlayerEntity,
)
