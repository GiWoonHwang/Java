package com.mysite.sbb.common.util;

@FunctionalInterface
public interface Predicate<T> {
    // T -> boolean
    boolean test(T t);

}
