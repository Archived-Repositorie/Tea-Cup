package io.github.justfoxx.teacup.v1.config

import com.google.gson.JsonObject
import io.github.justfoxx.teacup.v1.utils.JsonHelper
import net.fabricmc.loader.api.FabricLoader
import java.nio.file.Files
import java.nio.file.Path
import java.util.Optional

object ConfigLoader {
    fun <T> loadConfig(path: Path, configClass: Class<T>? = null): Pair<Optional<T & Any>, JsonObject> {
        val configPath = FabricLoader.getInstance().configDir.resolve(path)

        val configObject: JsonObject = if (Files.notExists(configPath)) {
            Files.createFile(configPath)
            JsonHelper.getDefaultJsonObject(
                configClass,
                configPath
            )
        } else {
            JsonHelper.readJsonObject(configPath)
        }

        return if(configClass != null)
            Pair(Optional.ofNullable(JsonHelper.convert(configObject, configClass)), configObject)
        else
            Pair(Optional.empty(), configObject)
    }
}