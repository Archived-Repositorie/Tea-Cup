package io.github.justfoxx.teacup.v1;

import io.github.justfoxx.teacup.v1.event.Events;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        Events.CONFIG_EVENT.invoke();
    }
}
