@FunctionalInterface
interface CustomInterface<T> {
    // abstract method 오직 하나
    T myCall();

    // default method 는 존재해도 상관없음
    default void printDefault() {
        System.out.println("Hello Default");
    }

    // static method 는 존재해도 상관없음
    static void printStatic() {
        System.out.println("Hello Static");
    }
}
//
//@FunctionalInterface
//public interface Predicate<T> {
//    boolean test(T t);
//}
//
//@FunctionalInterface
//public interface Consumer<T> {
//    void accept(T t);
//}
//
//@FunctionalInterface
//public interface Supplier<T> {
//    T get();
//}
//
//// T값을 받아 R타입을 리턴한다.
//@FunctionalInterface
//public interface Function<T, R>{
//    R apply(T t);
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
