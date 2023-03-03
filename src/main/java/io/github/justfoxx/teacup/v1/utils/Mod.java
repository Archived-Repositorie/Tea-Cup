package io.github.justfoxx.teacup.v1.utils;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

/**
 * A helper class for mods
 */
public class Mod {
    private final String name;
    private final Logger logger;
    private Path configPath;

    /**
     * @param name The name of the mod
     */
    public Mod(String name) {
        this.name = name;
        this.logger = LoggerFactory.getLogger(name);
    }

    /**
     * Gets the logger for the mod
     * @return Logger for the mod
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Gets the identifier for a resource
     * @param path The path to the resource
     * @return The identifier for the resource
     */
    public Identifier idOf(String path) {
        return new Identifier(name, path);
    }

    /**
     * Gets the path to the config file
     * @return The path to the config file
     */
    public Path getConfigPath() {
        if (this.configPath == null) {
            this.configPath = FabricLoader.getInstance().getConfigDir().resolve(name + ".json");
        }
        return this.configPath;
    }
}
