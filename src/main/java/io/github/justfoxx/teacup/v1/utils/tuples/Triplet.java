package io.github.justfoxx.teacup.v1.utils.tuples;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Triplet <A, B, C> extends Pair<A,B> {
    private final C c;

    public Triplet(A a, B b, C c) {
        super(a,b);
        this.c = c;
    }

    public C getC() {
        return c;
    }
}
