package io.github.justfoxx.teacup;

import io.github.justfoxx.teacup.v1.event.Events;
import io.github.justfoxx.teacup.v1.event.Mod;

import io.github.justfoxx.teacup.v1.utils.tuples.Pair;
import io.github.justfoxx.teacup.v1.utils.tuples.Singleton;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import java.nio.file.Path;
import java.util.Optional;

public class PreMain implements PreLaunchEntrypoint {
    public static final Mod MOD = new Mod("teacup");
    @Override
    public void onPreLaunch() {
        Events.TEST_EVENT.onEvent(
                () -> MOD.getLogger().info("Hello, World!"),
                new Singleton<>("Hello, World!")
        );
        Events.CONFIG_EVENT.onEvent(
                config -> MOD.getLogger().info("Config: " + config.toString()),
                new Pair<>(Path.of("config.json"), Optional.empty())
        );
    }
}
