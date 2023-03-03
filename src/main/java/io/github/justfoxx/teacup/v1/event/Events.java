package io.github.justfoxx.teacup.v1.event;

import com.google.gson.JsonObject;
import io.github.justfoxx.teacup.v1.registry.MapRegistry;
import io.github.justfoxx.teacup.v1.utils.JsonHelper;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;
import io.github.justfoxx.teacup.v1.utils.tuples.Pair;

import java.nio.file.Files;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class Events {
    static {
        CONFIG_EVENT = DataEventKey.of(new MapRegistry<>(),
                Events::configEvent
        );
    }

    public static final DataEventKey<
            ThrowingConsumer<JsonObject>,
            Pair<Mod, Optional<Object>>,
            Void
            > CONFIG_EVENT;

    private static void configEvent(Set<Map.Entry<ThrowingConsumer<JsonObject>, Pair<Mod, Optional<Object>>>> entries) throws Exception {
        for (var entry : entries) {
            var value = entry.getValue();
            var configPath = value.getA().getConfigPath();
            var defaultObject = value.getB();
            var invoker = entry.getKey();

            JsonObject configObject;
            if (Files.notExists(configPath)) {
                Files.createFile(configPath);
                configObject = JsonHelper.getDefaultJsonObject(defaultObject, configPath);
            } else {
                configObject = JsonHelper.readJsonObject(configPath);
            }
            invoker.accept(configObject);
        }
    }
    private Events() {}
}
