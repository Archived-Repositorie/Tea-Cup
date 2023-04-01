package io.github.justfoxx.teacup.v1.event

import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.TextContent

internal fun <Value> onIterator(
    entries: Iterable<(Value) -> Unit>,
    data: Value
) {
    for (entry in entries) {
        entry.invoke(data)
    }
}

internal fun onMessageTextModifier(
    entries: List<(MessageTextData) -> Text>,
    data: MessageTextData
): Text {
    var text = data.text
    val player = data.player
    for (entry in entries) {
        text = entry.invoke(MessageTextData(text, player))
    }
    return text
}

internal fun onTextStyleModifier(
    entries: List<(Style) -> Style>,
    data: Style
): Style {
    var style = data
    for (entry in entries) {
        style = entry.invoke(style)
    }
    return style
}

internal fun onTextModifier(
    entries: List<(TextContent) -> TextContent>,
    data: TextContent
): TextContent {
    var text = data
    for (entry in entries) {
        text = entry.invoke(text)
    }
    return text
}

internal fun onTextSiblingsModifier(
    entries: List<(List<Text>) -> List<Text>>,
    data: List<Text>
): List<Text> {
    var text = data
    for (entry in entries) {
        text = entry.invoke(text)
    }
    return text
}

