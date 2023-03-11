package io.github.justfoxx.teacup

import io.github.justfoxx.teacup.v1.event.Events
import io.github.justfoxx.teacup.v1.utils.Mod
import java.util.*

val mod = Mod("teacup")

@Suppress("unused")
fun preInit() {
    mod.logger.info("Initializing")
}

@Suppress("unused")
fun init() {
    Events.ON_ENTITY_DIED.onEvent({entity ->
        return@onEvent
    })
}







