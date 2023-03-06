package io.github.justfoxx.teacup.v1.event

import com.google.gson.JsonObject
import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import io.github.justfoxx.teacup.v1.registry.MapRegistry
import io.github.justfoxx.teacup.v1.utils.Mod
import net.minecraft.util.ActionResult
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
import oshi.util.tuples.Pair
import java.util.*

/**
 * A class that holds all the events
 */
object Events {
    /**
     * A config event that is called when the config is loaded
     */
    val CONFIG: DataEventKey<
                (JsonObject) -> Unit,
            Pair<Mod, Optional<Any>>,
            Void
            > =
        DataEventKey(
            MapRegistry()
        ) { data, _ -> EventFunctions.configEvent(data) }

    /**
     * An event that is called when a player uses an item
     */
    val ON_ITEM_USE: DataEventKey<
                (OnItemUseData) -> ActionResult,
                (OnItemUseData) -> Boolean,
            Pair<OnItemUseData, CallbackInfoReturnable<ActionResult>>> =
        DataEventKey(
            MapRegistry()
            ) { data, info -> EventFunctions.onItemUse(data, info!!) }
}