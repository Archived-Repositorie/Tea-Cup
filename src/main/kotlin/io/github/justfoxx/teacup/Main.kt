package io.github.justfoxx.teacup

import io.github.justfoxx.teacup.v1.event.Event
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
    //test
//    Events.ON_SERVER_STARTING.onEvent({ server ->
//        mod.logger.info("Server is ticking lowest ${Date()} ${server.ticks}")
//    },Event.Priority.LOWEST)
//    Events.ON_SERVER_STARTING.onEvent({ server ->
//        mod.logger.info("Server is ticking highest ${Date()} ${server.ticks}")
//    },Event.Priority.HIGHEST)
//    Events.ON_SERVER_STARTING.onEvent({ server ->
//        mod.logger.info("Server is ticking normal ${Date()} ${server.ticks}")
//    },Event.Priority.NORMAL)
//    Events.ON_SERVER_STARTING.onEvent({ server ->
//        mod.logger.info("Server is ticking high ${Date()} ${server.ticks}")
//    },Event.Priority.HIGH)
}







