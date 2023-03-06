package io.github.justfoxx.teacup.v1.utils

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.file.Path

class Mod(private val name: String) {
    val logger: Logger = LoggerFactory.getLogger(name)
    val configPath: Path = FabricLoader.getInstance().configDir.resolve("$name.json")
    /**
     * Gets the identifier for a resource
     * @param path The path to the resource
     * @return The identifier for the resource
     */
    fun idOf(path: String?): Identifier {
        return Identifier(name, path)
    }
}