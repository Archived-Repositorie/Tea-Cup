package io.github.justfoxx.teacup.v1.event

import com.google.gson.JsonObject
import io.github.justfoxx.teacup.v1.event.data.OnItemUseData
import io.github.justfoxx.teacup.v1.utils.JsonHelper.getDefaultJsonObject
import io.github.justfoxx.teacup.v1.utils.JsonHelper.readJsonObject
import io.github.justfoxx.teacup.v1.utils.Mod
import net.minecraft.entity.Entity
import java.nio.file.Files

/**
 * A class that holds all the event functions
 */
internal object EventFunctions {
    /**
     * The function that gets called when the config is loaded
     */
    fun configEvent(
        entries: Set<Map.Entry<(JsonObject) -> Unit, Mod>>
    ) {
        for ((invoker, value) in entries) {
            val configPath = value.configPath
            val defaultObject = value.configClass
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
        entries: Set<(OnItemUseData) -> Unit>,
        data: OnItemUseData
    ) {
        for (value in entries) {
            value.invoke(data)
        }
    }

    fun onEntityTick(
        entries: Set<(Entity) -> Unit>,
        data: Entity
    ) {
        for (value in entries) {
            value.invoke(data)
        }
    }
}
