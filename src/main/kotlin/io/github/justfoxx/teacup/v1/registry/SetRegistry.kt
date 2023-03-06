package io.github.justfoxx.teacup.v1.registry

import com.google.common.collect.ImmutableSet

/**
 * A registry that stores values by reference only.
 * @param V The type of values stored in the registry.
 */
class SetRegistry<V> {
    // Initialize the registry with MapRegistry, which stores values by reference.
    private val registry = MapRegistry<V, Any>()

    /**
     * Adds a value to the registry.
     * @param value The value to add.
     * @return The value added.
     */
    fun add(value: V): V {
        registry.add(value, Object())
        return value
    }

    /**
     * Gets all the values in the registry.
     * @return All the values in the registry.
     */
    val all: ImmutableSet<V>
        get() = ImmutableSet.copyOf(registry.all.map { it.key })
}
