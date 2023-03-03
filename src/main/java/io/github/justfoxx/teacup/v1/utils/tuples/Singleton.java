package io.github.justfoxx.teacup.v1.utils.tuples;

public class Singleton<A> implements Tuple<A> {
    private final A a;

    public Singleton(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

    public static <A> Singleton<A> of(A a) {
        return new Singleton<>(a);
    }
}
