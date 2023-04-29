package io.github.justfoxx.teacup.v2.event.data

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

data class SingletonData<Data>(
    val data: Data,
    val callback: CallbackInfo,
)

data class MutableSingletonData<Data>(
    var data: Setter<Data>,
)

