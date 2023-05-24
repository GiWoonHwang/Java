package com.mysite.sbb.common.util;

@FunctionalInterface
public interface Supplier<T> {
    // () -> T
    T get();
}
