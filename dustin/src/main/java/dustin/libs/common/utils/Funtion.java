package dustin.libs.common.utils;

@FunctionalInterface
public interface Funtion<T,R> {
    // T -> R
    R apply(T t);
}
