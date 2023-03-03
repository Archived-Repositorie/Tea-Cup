package io.github.justfoxx.teacup.v1.registry;

import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A registry that uses a concurrent {@link Set}
 * @param <V> The value type
 */
public class SetRegistry<V> {
    private final Set<V> registry = ConcurrentHashMap.newKeySet();

    /**
     * Adds a value to the registry
     * @param value The value to add
     * @return The value added
     */
    public V add(V value) {
        Objects.requireNonNull(value);
        registry.add(value);
        return value;
    }

    /**
     * Gets all the values in the registry
     * @return All the values in the registry
     */
    public ImmutableSet<V> getAll() {
        return ImmutableSet.copyOf(registry);
    }
}
