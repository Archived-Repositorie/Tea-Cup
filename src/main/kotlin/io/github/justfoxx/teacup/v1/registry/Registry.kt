package io.github.justfoxx.teacup.v1.registry

interface Registry<V> {
    fun getAll(): List<V>
}