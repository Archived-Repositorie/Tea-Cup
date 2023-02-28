package io.github.justfoxx.teacup.v1.utils.tuples;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Quintet <A, B, C, D, E> extends Quartet<A,B,C,D> {
    private final E e;

    public Quintet(A a, B b, C c, D d, E e) {
        super(a,b,c,d);
        this.e = e;
    }

    public E getE() {
        return e;
    }
}
