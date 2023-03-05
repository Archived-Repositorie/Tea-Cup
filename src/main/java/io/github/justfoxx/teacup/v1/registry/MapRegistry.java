package io.github.justfoxx.teacup.v1.registry;

import com.google.common.collect.ImmutableSet;
import oshi.util.tuples.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A registry that uses a {@link ConcurrentHashMap}
 * @param <K> The key type
 * @param <V> The value type
 */
public class MapRegistry<K,V> {
    protected final Map<K,V> registry = new ConcurrentHashMap<>();

    /**
     * Adds a key and value to the registry
     * @param key The key to add
     * @param value The value to add
     * @return A pair of the key and value
     */
    public Pair<K, V> add(K key, V value) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(key);
        registry.putIfAbsent(key, value);
        return new Pair<>(key, value);
    }

    /**
     * Use {@link MapRegistry#getOptional(K)} instead
     * @param key The key to get
     * @return The value associated with the key
     */
    public V get(K key) {
        return registry.get(key);
    }

    /**
     * Gets a value from the registry
     * @param key The key to get
     * @return An optional of the value associated with the key
     */
    public Optional<V> getOptional(K key) {
        Objects.requireNonNull(key);
        return Optional.ofNullable(get(key));
    }

    /**
     * Gets all the entries in the registry
     * @return All the entries in the registry
     */
    public ImmutableSet<Map.Entry<K,V>> getAll() {
        return ImmutableSet.copyOf(registry.entrySet());
    }
}
