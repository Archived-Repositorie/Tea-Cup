package io.github.justfoxx.teacup.v1.registry

interface KeyRegistry<V,K> : Registry<V> {
    fun register(value: V, key: K)
}