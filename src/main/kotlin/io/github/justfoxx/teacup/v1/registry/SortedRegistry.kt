package io.github.justfoxx.teacup.v1.registry

import io.github.justfoxx.teacup.v1.utils.addSorted

class SortedRegistry<Value,Key : Comparable<Key>> : KeyRegistry<Value,Key> {
    private val registry = mutableListOf<SortKey<Value, Key>>()

    override fun register(value: Value, key: Key) {
        registry.addSorted(SortKey(value, key))
    }

    override fun getAll(): List<Value> = registry.map { it.value }.toList()
}
