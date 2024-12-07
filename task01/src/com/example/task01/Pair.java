package com.example.task01;

import java.util.function.BiConsumer;

public class Pair<F, S> {
    private F first;
    private S second;
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public boolean equals(Pair<F, S> p) {
        return first.equals(p.getFirst()) && second.equals(p.getSecond());
    }

    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    public static <F, S> Pair<F, S> of(F first, S second) {
        return new Pair<>(first, second);
    }

    public void ifPresent(BiConsumer<? super F, ? super S> biConsumer){
        if (first != null && second != null){
            biConsumer.accept(first, second);
        }
    }
}
