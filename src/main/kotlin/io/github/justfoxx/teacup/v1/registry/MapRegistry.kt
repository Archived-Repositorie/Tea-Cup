package io.github.justfoxx.teacup.v1.registry

import com.google.common.collect.ImmutableSet
import oshi.util.tuples.Pair
import java.util.concurrent.ConcurrentHashMap

class MapRegistry<K, V> {
    private val registry: MutableMap<K, V> = ConcurrentHashMap()

    /**
     * Adds a key and value to the registry
     * @param key The key to add
     * @param value The value to add
     * @return A pair of the key and value
     */
    fun add(key: K, value: V): Pair<K, V> {
        registry.putIfAbsent(key, value)
        return Pair(key, value)
    }

    /**
     * Gets a value from the registry
     * @param key The key to get
     * @return The value associated with the key
     */
    operator fun get(key: K): V? {
        return registry[key]
    }

    val all: ImmutableSet<Map.Entry<K, V>>
        /**
         * Gets all the entries in the registry
         * @return All the entries in the registry
         */
        get() = ImmutableSet.copyOf(registry.entries)
}