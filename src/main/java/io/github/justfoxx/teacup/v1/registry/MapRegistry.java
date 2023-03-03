package io.github.justfoxx.teacup.v1.registry;

import com.google.common.collect.ImmutableSet;
import io.github.justfoxx.teacup.v1.utils.tuples.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapRegistry<K,V> implements Iterable<Map.Entry<K,V>> {
    protected final Map<K,V> registry = new ConcurrentHashMap<>();

    public Pair<K, V> add(K key, V value) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(key);
        registry.putIfAbsent(key, value);
        return Pair.of(key, value);
    }

    private V get(K key) {
        return registry.get(key);
    }

    public Optional<V> getOptional(K key) {
        Objects.requireNonNull(key);
        return Optional.ofNullable(get(key));
    }

    public ImmutableSet<Map.Entry<K,V>> getAll() {
        return ImmutableSet.copyOf(registry.entrySet());
    }

    @NotNull
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return registry.entrySet().iterator();
    }
}
