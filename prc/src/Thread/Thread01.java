package Thread;

public class Thread01 {
    public static void main(String[] args){
        Thread thread1 = new Thread(new ThreadWithRunnable());
        Thread thread2 = new Thread(new ThreadWithRunnable());

        thread2.setPriority(10); // Thread-1의 우선순위를 10으로 변경함.

        thread1.start(); // Thread-0 실행

        thread2.start(); // Thread-1 실행



        System.out.println(thread1.getPriority());

        System.out.println(thread2.getPriority());



    }
}
