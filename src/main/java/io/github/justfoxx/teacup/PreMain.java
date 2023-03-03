package io.github.justfoxx.teacup;

import io.github.justfoxx.teacup.v1.event.Events;
import io.github.justfoxx.teacup.v1.event.Mod;

import io.github.justfoxx.teacup.v1.utils.tuples.Pair;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import java.util.Optional;

public class PreMain implements PreLaunchEntrypoint {
    public static final Mod MOD = new Mod("teacup");
    @Override
    public void onPreLaunch() {
        Events.CONFIG_EVENT.onEvent(
                config -> MOD.getLogger().info("Config: " + config.toString()),
                new Pair<>(MOD, Optional.empty())
        );
    }
}
