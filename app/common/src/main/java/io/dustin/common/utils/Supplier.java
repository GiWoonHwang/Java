package io.dustin.common.utils;

@FunctionalInterface
public interface Supplier<T> {
    // () -> T
    T get();
}
