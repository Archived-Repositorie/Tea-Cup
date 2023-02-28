package io.github.justfoxx.teacup.v1.event;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod {
    private final String name;
    private final Logger logger;

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
}
