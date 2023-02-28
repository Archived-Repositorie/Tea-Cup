package io.github.justfoxx.teacup.v1.utils.tuples;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Quartet <A, B, C, D> extends Triplet<A,B,C> {
    private final D d;

    public Quartet(A a, B b, C c, D d) {
        super(a,b,c);
        this.d = d;
    }

    public D getD() {
        return d;
    }
}
