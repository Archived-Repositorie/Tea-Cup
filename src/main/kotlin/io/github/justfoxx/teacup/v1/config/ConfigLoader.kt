package io.github.justfoxx.teacup.v1.config

import com.google.gson.JsonObject
import io.github.justfoxx.teacup.v1.utils.convertTo
import io.github.justfoxx.teacup.v1.utils.getDefaultJsonObject
import io.github.justfoxx.teacup.v1.utils.readJsonObject
import net.fabricmc.loader.api.FabricLoader
import java.nio.file.Files
import java.nio.file.Path
import java.util.Optional

object ConfigLoader {
    /**
     * Loads a configuration file from the given path, creating it if it doesn't exist.
     *
     * @param path The path to the configuration file.
     * @param configClass The class of the configuration object. If null, returns the raw JSON object.
     * @return A Pair of an Optional of the loaded configuration object, and the raw JSON object.
     */
    @JvmStatic fun <T> loadOrCreateConfigFile(path: Path, configClass: Class<T>? = null): Pair<Optional<T & Any>, JsonObject> {
        val configPath = FabricLoader.getInstance().configDir.resolve(path)

        val configObject: JsonObject = if (Files.notExists(configPath)) {
            createConfigFile(configPath, configClass)
        } else {
            configPath.readJsonObject()
        }


        return if (configClass != null)
            Pair(Optional.ofNullable(configObject.convertTo(configClass)), configObject)
        else
            Pair(Optional.empty(), configObject)
    }

    private fun createConfigFile(configPath: Path, configClass: Class<*>? = null): JsonObject {
        Files.createFile(configPath)
        return configPath.getDefaultJsonObject(
            configClass
        )
    }
}