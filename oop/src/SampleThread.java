import java.util.ArrayList;
public class SampleThread extends Thread{
    int seq;

    public SampleThread(int seq){
        this.seq = seq;
    }

    public void run() { // Thread를 상속하려면 run 메서드를 구현해야 한다.
        System.out.println(this.seq + " thread start.");  // 쓰레드 시작
        try{
            Thread.sleep(1000);

        }catch (Exception e){

        }
        System.out.println(this.seq + " thread end"); // 쓰레드 종료

    }

    public static void main(String[] args){
        ArrayList<Thread> threads = new ArrayList<>();
//        SampleThread sampleThread = new SampleThread();
//        // Thread 클래스는 start 실행 시 run 메서드가 수행되도록 내부적으로 동작한다.
//        sampleThread.start();
        for(int i = 0; i < 10; i ++){
            Thread t = new SampleThread(i);
            t.start();
            threads.add(t);
        }
        for(int i = 0; i < threads.size(); i ++) {
            Thread t = threads.get(i);
            try {
                t.join(); // t 쓰레드가 종료할 때까지 기다린다.
            } catch (Exception e) {
            }
        /*
        쓰레드 프로그래밍시 가장 많이 실수하는 부분이 바로 쓰레드가 종료되지 않았는데 쓰레드가 종료된 줄 알고 그 다음 로직을 수행하게 만드는 일이다.
        쓰레드가 종료된 후 그 다음 로직을 수행해야 할 때 꼭 필요한 join 메서드를 꼭 기억하자.
        */
            System.out.println("main end");
        }
    }
}

/*
보통 쓰레드 객체를 만들 때 위의 예처럼 Thread 클래스를 상속하여 만들기도 하지만 보통은 Runnable 인터페이스를 구현하도록 하는 방법을 주로 사용한다. 왜냐하면 Thread 클래스를 상속하면 다른 클래스를 상속할 수 없기 때문이다.

위에서 만든 예제를 Runnable 인터페이스를 사용하는 방식으로 변경 해 보자.

public class Sample implements Runnable {
    int seq;
    public Sample(int seq) {
        this.seq = seq;
    }

    public void run() {
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
        }
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new Sample(i));
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }
}
 */
