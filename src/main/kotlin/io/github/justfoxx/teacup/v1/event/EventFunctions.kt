package io.github.justfoxx.teacup.v1.event

import net.minecraft.text.Text

internal fun <V> onIterator(
    entries: Iterable<(V) -> Unit>,
    data: V
) {
    for (entry in entries) {
        entry.invoke(data)
    }
}

internal fun onTextModifier(
    entries: List<(TextData) -> Text>,
    data: TextData
): Text {
    var text = data.text
    val player = data.player
    for (entry in entries) {
        text = entry.invoke(TextData(text, player))
    }
    return text
}

