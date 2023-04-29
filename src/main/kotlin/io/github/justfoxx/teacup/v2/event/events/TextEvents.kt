package io.github.justfoxx.teacup.v2.event.events

import io.github.justfoxx.teacup.v2.event.EventHandler
import io.github.justfoxx.teacup.v2.event.data.MutableSingletonData
import io.github.justfoxx.teacup.v2.event.onMutableIterator
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.TextContent

object TextEvents {
    @JvmStatic val ON_TEXT_STYLE_MODIFY = EventHandler.ofSingleton<MutableSingletonData<Style>> { data -> { info ->
        onMutableIterator(data, info)
    }}

    @JvmStatic val ON_TEXT_CONTENT_MODIFY = EventHandler.ofSingleton<MutableSingletonData<TextContent>> { data -> { info ->
        onMutableIterator(data, info)
    }}

    @JvmStatic val ON_TEXT_SIBLINGS_MODIFY = EventHandler.ofSingleton<MutableSingletonData<List<Text>>> { data -> { info ->
        onMutableIterator(data, info)
    }}
}