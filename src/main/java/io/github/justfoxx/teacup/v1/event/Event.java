package io.github.justfoxx.teacup.v1.event;

import com.google.common.collect.ImmutableSet;
import io.github.justfoxx.teacup.v1.utils.ThrowingConsumer;
import io.github.justfoxx.teacup.v1.utils.tuples.Tuple;

import java.util.Map;
import java.util.Set;

public interface Event <V,T> {
    void invoke(T value);
    ImmutableSet<?> getAll();

    static <V,T> EventKey<V,T> create(Set<V> registry, ThrowingConsumer<T> invoker) {
        return new EventKey<>(registry, invoker);
    }

    static <V,D extends Tuple<?>,T> DataEventKey<V,D,T> create(Map<V,D> registry, ThrowingConsumer<T> invoker) {
        return new DataEventKey<>(registry, invoker);
    }

}
