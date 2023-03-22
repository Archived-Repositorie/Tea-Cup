package io.github.justfoxx.teacup.v1.event

import io.github.justfoxx.teacup.v1.registry.SortedRegistry
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
    @JvmStatic val ON_SERVER_STARTING: SingletonEvent<(SingletonData<MinecraftServer>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server has started up.
     * This event is triggered when the server has finished starting up and is ready to accept connections.
     */
    @JvmStatic val ON_SERVER_STARTED: SingletonEvent<(SingletonData<MinecraftServer>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server is stopping.
     * This event is triggered when the server is in the process of shutting down.
     */
    @JvmStatic val ON_SERVER_STOPPING: SingletonEvent<(SingletonData<MinecraftServer>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server has stopped.
     * This event is triggered when the server has completely shut down.
     */
    @JvmStatic val ON_SERVER_STOPPED: SingletonEvent<(SingletonData<MinecraftServer>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server is ticking.
     * This event is triggered every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKING: SingletonEvent<(SingletonData<MinecraftServer>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when the server has finished ticking.
     * This event is triggered after every tick while the server is running.
     */
    @JvmStatic val ON_SERVER_TICKED: SingletonEvent<(SingletonData<MinecraftServer>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when a player starts using an item.
     * This event is triggered when the player starts the action of using an item.
     */
    @JvmStatic val ON_ITEM_USING: SingletonEvent<(OnItemUseData) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when a player finishes using an item.
     * This event is triggered when the player finishes the action of using an item.
     */
    @JvmStatic val ON_ITEM_USED: SingletonEvent<(OnItemUseData) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when an entity starts ticking.
     * This event is triggered when an entity starts updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKING: SingletonEvent<(SingletonData<Entity>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when an entity finishes ticking.
     * This event is triggered when an entity has finished updating its state.
     */
    @JvmStatic val ON_ENTITY_TICKED: SingletonEvent<(SingletonData<Entity>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when an entity is about to die.
     * This event is triggered when an entity is about to die.
     */
    @JvmStatic val ON_ENTITY_DYING: SingletonEvent<(SingletonData<LivingEntity>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    /**
     * Event key for when an entity has died.
     * This event is triggered when an entity has died.
     */
    @JvmStatic val ON_ENTITY_DIED: SingletonEvent<(SingletonData<LivingEntity>) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}


    @JvmStatic val ON_INTERNAL_SEND_PACKET: SingletonEvent<(InternalPacketData) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    @JvmStatic val ON_MESSAGE_SEND: SingletonEvent<(MessageData) -> Unit> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onIterator(data, info)
        }}

    @JvmStatic val ON_MESSAGE_MODIFY: SingletonEvent<(MessageTextData) -> Text> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onMessageTextModifier(data, info)
        }}

    @JvmStatic val ON_TEXT_STYLE_MODIFY: SingletonEvent<(Style) -> Style> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onTextStyleModifier(data, info)
        }}

    @JvmStatic val ON_TEXT_CONTENT_MODIFY: SingletonEvent<(TextContent) -> TextContent> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onTextModifier(data, info)
        }}

    @JvmStatic val ON_TEXT_SIBLINGS_MODIFY : SingletonEvent<(List<Text>) -> List<Text>> =
        SingletonEvent(SortedRegistry()) { data -> { info ->
            onTextSiblingsModifier(data, info)
        }}
}