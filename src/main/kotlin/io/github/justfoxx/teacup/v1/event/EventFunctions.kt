package io.github.justfoxx.teacup.v1.event

import com.google.gson.JsonObject
import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import io.github.justfoxx.teacup.v1.utils.JsonHelper.getDefaultJsonObject
import io.github.justfoxx.teacup.v1.utils.JsonHelper.readJsonObject
import io.github.justfoxx.teacup.v1.utils.Mod
import net.minecraft.util.ActionResult
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
import oshi.util.tuples.Pair
import java.nio.file.Files
import java.util.*
/**
 * A class that holds all the event functions
 */
internal object EventFunctions {
    /**
     * The function that gets called when the config is loaded
     */
    fun configEvent(
        entries: Set<Map.Entry<(JsonObject) -> Unit, Pair<Mod, Optional<Any>>>>
    ) {
        for ((invoker, value) in entries) {
            val configPath = value.a.configPath
            val defaultObject = value.b
            val configObject: JsonObject = if (Files.notExists(configPath)) {
                Files.createFile(configPath)
                getDefaultJsonObject(
                    defaultObject,
                    configPath
                )
            } else {
                readJsonObject(configPath)
            }
            invoker.invoke(configObject)
        }
    }

    /**
     * The function that gets called when a player uses an item
     */
    fun onItemUse(
        entries: Set<Map.Entry<(OnItemUseData) -> ActionResult, (OnItemUseData) -> Boolean>>,
        data: Pair<OnItemUseData, CallbackInfoReturnable<ActionResult>>
    ) {
        for ((key, value) in entries) {
            if (!value.invoke(data.a)) {
                continue
            }
            val returned = key.invoke(data.a)
            if (returned != ActionResult.PASS) {
                data.b.returnValue = returned
            }
        }
    }
}
