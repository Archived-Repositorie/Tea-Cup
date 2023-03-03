package io.github.justfoxx.teacup.v1.event;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class Mod {
    private final String name;
    private final Logger logger;
    private Path configPath;

    public Mod(String name) {
        this.name = name;
        this.logger = LoggerFactory.getLogger(name);
    }

    public Logger getLogger() {
        return logger;
    }

    public Identifier idOf(String path) {
        return new Identifier(name, path);
    }

    public Path getConfigPath() {
        if (this.configPath == null) {
            this.configPath = FabricLoader.getInstance().getConfigDir().resolve(name + ".json");
        }
        return this.configPath;
    }
}
