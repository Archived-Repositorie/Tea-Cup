package io.github.justfoxx.teacup.v1.registry

import io.github.justfoxx.teacup.v1.utils.addSorted

class SortedRegistry<V,K : Comparable<K>> {
    private val registry = mutableListOf<Key<V, K>>()

    fun register(value: V, sortKey: K) {
        registry.addSorted(Key(value, sortKey))
    }

    val all: List<V>
        get() = registry.toList().map { it.value }.toList()

    data class Key<T,K : Comparable<K>>(val value: T,val sortKey: K): Comparable<Key<T,K>> {
        override fun compareTo(other: Key<T,K>): Int {
            return this.sortKey.compareTo(other.sortKey)
        }
    }
}
