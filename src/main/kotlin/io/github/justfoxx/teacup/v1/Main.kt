package io.github.justfoxx.teacup.v1

import io.github.justfoxx.teacup.v1.event.Events

@Suppress("unused")
fun init() {
    Events.CONFIG.invoke()
}