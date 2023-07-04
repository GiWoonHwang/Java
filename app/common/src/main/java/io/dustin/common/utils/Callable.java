package io.dustin.common.utils;

@FunctionalInterface
public interface Callable<V> {
    // () -> T
    V call() throws Exception;
}
