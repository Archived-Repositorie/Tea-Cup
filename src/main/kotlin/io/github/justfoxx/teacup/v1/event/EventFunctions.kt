package io.github.justfoxx.teacup.v1.event

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text

internal fun <V> onIterator(
    entries: Iterable<(V) -> Unit>,
    data: V
) {
    for (entry in entries) {
        entry.invoke(data)
    }
}

internal fun onMessageModifier(
    entries: Iterable<(Text, ServerPlayerEntity) -> Text>,
    data: Pair<Text, ServerPlayerEntity>
): Text {
    var text = data.first
    val player = data.second
    for (entry in entries) {
        text = entry.invoke(text, player)
    }
    return text
}

