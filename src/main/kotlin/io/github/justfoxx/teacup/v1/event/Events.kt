package io.github.justfoxx.teacup.v1.event

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.server.MinecraftServer
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.TextContent

object Events {
    /**
     * Event key for when the server is starting up.
     * This event is triggered when the server is in the process of starting up.
     */
    @JvmStatic val ON_SERVER_STARTING = PriorityEvent.ofSingleton<(SingletonData<MinecraftServer>) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server has started up.
     * This event is triggered when the server has finished starting up and is ready to accept connections.
     */
    @JvmStatic val ON_SERVER_STARTED = PriorityEvent.ofSingleton<(SingletonData<MinecraftServer>) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server is stopping.
     * This event is triggered when the server is in the process of shutting down.
     */
    @JvmStatic val ON_SERVER_STOPPING = PriorityEvent.ofSingleton<(SingletonData<MinecraftServer>) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server has stopped.
     * This event is triggered when the server has completely shut down.
     */
    @JvmStatic val ON_SERVER_STOPPED = PriorityEvent.ofSingleton<(SingletonData<MinecraftServer>) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server is ticking.
     * This event is triggered every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKING = PriorityEvent.ofSingleton<(SingletonData<MinecraftServer>) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server has finished ticking.
     * This event is triggered after every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKED = PriorityEvent.ofSingleton<(SingletonData<MinecraftServer>) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when a player starts using an item.
     * This event is triggered when the player starts the action of using an item.
     */
    @JvmStatic val ON_ITEM_USING = PriorityEvent.ofSingleton<(OnItemUseData) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when a player finishes using an item.
     * This event is triggered when the player finishes the action of using an item.
     */
    @JvmStatic val ON_ITEM_USED = PriorityEvent.ofSingleton<(OnItemUseData) -> Unit> { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when an entity starts ticking.
     * This event is triggered when an entity starts updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKING = PriorityEvent.ofSingleton<(SingletonData<Entity>) -> Unit> { data -> { info ->
        onIterator(data, info)
    }}

    /**
     * Event key for when an entity finishes ticking.
     * This event is triggered when an entity has finished updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKED = PriorityEvent.ofSingleton<(SingletonData<Entity>) -> Unit> { data -> { info ->
        onIterator(data, info)
    }}

    /**
     * Event key for when an entity is about to die.
     * This event is triggered when an entity is about to die.
     */
    @JvmStatic val ON_ENTITY_DYING = PriorityEvent.ofSingleton<(SingletonData<LivingEntity>) -> Unit> { data -> { info ->
        onIterator(data, info)
    }}
    /**
     * Event key for when an entity has died.
     * This event is triggered when an entity has died.
     */
    @JvmStatic val ON_ENTITY_DIED = PriorityEvent.ofSingleton<(SingletonData<LivingEntity>) -> Unit> { data -> { info ->
        onIterator(data, info)
    }}


    @JvmStatic val ON_INTERNAL_SEND_PACKET = PriorityEvent.ofSingleton<(InternalPacketData) -> Unit> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_MESSAGE_SEND = PriorityEvent.ofSingleton<(MessageData) -> Unit> { data -> { info ->
        onIterator(data, info)
    }}

    @JvmStatic val ON_MESSAGE_MODIFY = PriorityEvent.ofSingleton<(MessageTextData) -> Text> { data -> { info ->
        onMessageTextModifier(data, info)
    }}

    @JvmStatic val ON_TEXT_STYLE_MODIFY = PriorityEvent.ofSingleton<(Style) -> Style> { data -> { info ->
        onTextStyleModifier(data, info)
    }}

    @JvmStatic val ON_TEXT_CONTENT_MODIFY = PriorityEvent.ofSingleton<(TextContent) -> TextContent> { data -> { info ->
        onTextModifier(data, info)
    }}

    @JvmStatic val ON_TEXT_SIBLINGS_MODIFY = PriorityEvent.ofSingleton<(List<Text>) -> List<Text>> { data -> { info ->
        onTextSiblingsModifier(data, info)
    }}
}