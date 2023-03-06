package io.github.justfoxx.teacup.v1.registry

import oshi.util.tuples.Pair
import java.util.concurrent.ConcurrentHashMap

/**
 * A thread-safe registry that stores key-value pairs.
 */
class MapRegistry<K, V> {

    // Use ConcurrentHashMap to ensure thread-safety
    private val registry: MutableMap<K, V> = ConcurrentHashMap()

    /**
     * Adds a key-value pair to the registry.
     *
     * @param key The key to add.
     * @param value The value to add.
     * @return A Pair of the added key and value.
     */
    fun add(key: K, value: V): Pair<K, V> {
        registry.putIfAbsent(key, value)
        return Pair(key, value)
    }

    /**
     * Gets the value associated with the given key from the registry.
     *
     * @param key The key to get the value for.
     * @return The value associated with the key, or null if the key is not found in the registry.
     */
    operator fun get(key: K): V? {
        return registry[key]
    }

    /**
     * Gets an immutable set of all key-value pairs in the registry.
     *
     * @return An immutable set of all key-value pairs in the registry.
     */
    val all: Set<Map.Entry<K, V>>
        get() = registry.entries.toSet()
}