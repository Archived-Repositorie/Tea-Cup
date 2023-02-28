package io.github.justfoxx.teacup.v1.utils.tuples;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface Tuple<A> {
    A getA();

    static <A> Singleton<A> of(A a) {
        return new Singleton<>(a);
    }
    static <A,B> Pair<A,B> of(A a, B b) {
        return new Pair<>(a,b);
    }
    static <A,B,C> Triplet<A,B,C> of(A a, B b, C c) {
        return new Triplet<>(a,b,c);
    }
    static <A,B,C,D> Quartet<A,B,C,D> of(A a, B b, C c, D d) {
        return new Quartet<>(a,b,c,d);
    }
    static <A,B,C,D,E> Quintet<A,B,C,D,E> of(A a, B b, C c, D d, E e) {
        return new Quintet<>(a,b,c,d,e);
    }
    static <A,B,C,D,E> Sequence<A,B,C,D,E> of(A a, B b, C c, D d, E e, Object... sequence) {
        return new Sequence<>(a,b,c,d,e,sequence);
    }
}
