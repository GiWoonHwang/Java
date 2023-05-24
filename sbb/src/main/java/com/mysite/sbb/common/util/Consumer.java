package com.mysite.sbb.common.util;

@FunctionalInterface
public interface Consumer<T> {
    // T -> void
    void accept(T t);
}
