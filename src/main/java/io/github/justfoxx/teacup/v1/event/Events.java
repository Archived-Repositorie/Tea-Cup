package io.github.justfoxx.teacup.v1.event;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import io.github.justfoxx.teacup.PreMain;
import io.github.justfoxx.teacup.v1.utils.JsonHelper;
import io.github.justfoxx.teacup.v1.utils.tuples.Pair;
import io.github.justfoxx.teacup.v1.utils.tuples.Singleton;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Events {
    static {
        TEST_EVENT = Event.create(new ConcurrentHashMap<>(), value ->
                value.forEach(key ->
                        PreMain.MOD.getLogger().info("Event: " + key.getValue().getA())
                )
        );
        CONFIG_EVENT = Event.create(new ConcurrentHashMap<>(), Events::configLoad);
    }

    private static void configLoad(ImmutableSet<Map.Entry<Consumer<JsonObject>, Pair<Path, Optional<Object>>>> entries) throws Exception {
        // Get the config directory
        var configDir = FabricLoader.getInstance().getConfigDir();

        for (var entry : entries) {
            // Get the config path, default class, and invoker
            var value = entry.getValue();
            var configPath = configDir.resolve(value.getA());
            var defaultClass = value.getB();
            var invoker = entry.getKey();

            JsonObject configObject;
            if (Files.notExists(configPath)) {
                Files.createFile(configPath);
                configObject = defaultClass.isPresent() ?
                        JsonHelper.writeJsonObject(defaultClass.get(), configPath) :
                        JsonHelper.writeJsonObject(new JsonObject(), configPath);
            } else {
                configObject = JsonHelper.readJsonObject(configPath);
            }
            invoker.accept(configObject);
        }
    }

    public static final DataEventKey<
            Runnable,
            Singleton<String>,
            ImmutableSet<Map.Entry<Runnable, Singleton<String>>>
            > TEST_EVENT;

    public static final DataEventKey<
            Consumer<JsonObject>,
            Pair<Path, Optional<Object>>,
            ImmutableSet<Map.Entry<Consumer<JsonObject>, Pair<Path, Optional<Object>>>>
            > CONFIG_EVENT;
    private Events() {}


}
