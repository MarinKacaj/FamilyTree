package com.family.tree.util;

public class Either<A, B> {
    private A left;
    private B right;

    private Either(A a, B b) {
        left = a;
        right = b;
    }

    public static <A, B> Either<A, B> left(A a) {
        return new Either<>(a, null);
    }

    public static <A, B> Either<A, B> right(B b) {
        return new Either<>(null, b);
    }

    public A left() {
        return left;
    }

    public boolean isLeft() {
        return left != null;
    }

    public boolean isRight() {
        return right != null;
    }

    public B right() {
        return right;
    }
}