package io.dustin.board.common.utils;

@FunctionalInterface
public interface Supplier<T> {
    // () -> T
    T get();
}
