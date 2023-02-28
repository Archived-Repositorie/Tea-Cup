package io.github.justfoxx.teacup.v1.utils.tuples;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Pair <A, B> implements Tuple<A> {
    private final A a;
    private final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }
}
