package io.github.justfoxx.teacup.v1.config

import com.google.gson.JsonObject
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
     * @param configObject The class of the configuration object. If null, returns the raw JSON object.
     * @return A Pair of an Optional of the loaded configuration object, and the raw JSON object.
     */
    @JvmStatic fun <T> loadOrCreateConfigFile(path: Path, configObject: T? = null): Pair<Optional<T & Any>, JsonObject> {
        val configPath = FabricLoader.getInstance().configDir.resolve(path)

        val configJsonObject: JsonObject = if (Files.notExists(configPath)) {
            createConfigFile(configPath, configObject)
        } else {
            configPath.readJsonObject()
        }


        return if (configObject != null)
            Pair(Optional.ofNullable(configObject), configJsonObject)
        else
            Pair(Optional.empty(), configJsonObject)
    }

    private fun createConfigFile(configPath: Path, configObject: Any? = null): JsonObject {
        Files.createFile(configPath)
        return configPath.getDefaultJsonObject(
            configObject
        )
    }
}