package io.github.justfoxx.teacup.v1.utils

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.file.Path

/**
 * A class representing a Fabric mod.
 * @param name The name of the mod.
 */
class Mod(private val name: String) {
    // Initialize a logger for the mod.
    val logger: Logger = LoggerFactory.getLogger(name)
    // Initialize a path for the mod's configuration file.
    val configPath: Path = FabricLoader.getInstance().configDir.resolve("$name.json")

    /**
     * Gets the identifier for a resource.
     * @param path The path to the resource.
     * @return The identifier for the resource.
     */
    fun idOf(path: String?): Identifier {
        return Identifier(name, path)
    }
}