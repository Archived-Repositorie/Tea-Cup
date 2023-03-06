package io.github.justfoxx.teacup

import io.github.justfoxx.teacup.v1.event.Events
import io.github.justfoxx.teacup.v1.utils.JsonHelper
import io.github.justfoxx.teacup.v1.utils.Mod
import oshi.util.tuples.Pair
import java.util.Optional

val mod = Mod("teacup")

@Suppress("unused")
fun init() {
    mod.logger.info("Hello")
    Events.CONFIG.onEvent(
        { json ->
            mod.logger.info("Config: $json")
            val out = JsonHelper.GSON.fromJson(json, TestConfig::class.java)
            mod.logger.info("Config: ${out.test}")
        },
        Pair(mod, Optional.of(TestConfig(3)))
    )
}

data class TestConfig(val test: Int)