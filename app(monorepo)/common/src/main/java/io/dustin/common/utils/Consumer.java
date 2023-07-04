package io.dustin.common.utils;

@FunctionalInterface
public interface Consumer<T> {
    // T -> void
    void accept(T t);
}
