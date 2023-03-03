package io.github.justfoxx.teacup.v1.registry;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SetRegistry<V> implements Iterable<V> {
    private final Set<V> registry = ConcurrentHashMap.newKeySet();
    
    public V add(V value) {
        Objects.requireNonNull(value);
        registry.add(value);
        return value;
    }
    
    public ImmutableSet<V> getAll() {
        return ImmutableSet.copyOf(registry);
    }

    @NotNull
    @Override
    public Iterator<V> iterator() {
        return registry.iterator();
    }
}
