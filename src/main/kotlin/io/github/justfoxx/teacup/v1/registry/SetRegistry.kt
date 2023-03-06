package io.github.justfoxx.teacup.v1.registry

import com.google.common.collect.ImmutableSet

/**
 * A registry that stores values in only by value
</V> */
class SetRegistry<V> {
    private val registry = MapRegistry<V, Any>()

    /**
     * Adds a value to the registry
     * @param value The value to add
     * @return The value added
     */
    fun add(value: V): V {
        registry.add(value, Object())
        return value
    }

    val all: ImmutableSet<V>
        /**
         * Gets all the values in the registry
         * @return All the values in the registry
         */
        get() = ImmutableSet.copyOf(registry.all.map { it.key })
}