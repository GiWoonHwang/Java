package com.mysite.sbb.common.util;

@FunctionalInterface
public interface Funtion<T,R> {
    // T -> R
    R apply(T t);
}
