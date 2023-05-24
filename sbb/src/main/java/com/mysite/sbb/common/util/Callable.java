package com.mysite.sbb.common.util;

@FunctionalInterface
public interface Callable<V> {
    // () -> T
    V call() throws Exception;
}
