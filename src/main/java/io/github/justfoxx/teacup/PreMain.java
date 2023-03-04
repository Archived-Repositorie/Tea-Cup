package io.github.justfoxx.teacup;

import io.github.justfoxx.teacup.v1.utils.Mod;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    public static final Mod MOD = new Mod("teacup");
    @Override
    public void onPreLaunch() {
    }
}
