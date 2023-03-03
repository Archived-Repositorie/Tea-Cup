package io.github.justfoxx.teacup.v1.utils.tuples;

public class Sequence<A, B, C, D, E> extends Quintet<A, B, C, D, E> {
    private final Object[] seq;
    public Sequence(A a, B b, C c, D d, E e, Object... seq) {
        super(a, b, c, d, e);
        this.seq = seq;
    }
    public Object[] getSeq() {
        return seq;
    }

    public static <A, B, C, D, E> Sequence<A, B, C, D, E> of(A a, B b, C c, D d, E e, Object... seq) {
        return new Sequence<>(a, b, c, d, e, seq);
    }
}
