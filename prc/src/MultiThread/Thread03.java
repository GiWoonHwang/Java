package MultiThread;

/*
데몬 스레드(deamon thread)란 다른 일반 스레드의 작업을 돕는 보조적인 역할을 하는 스레드를 가리킵니다.

따라서 데몬 스레드는 일반 스레드가 모두 종료되면 더는 할 일이 없으므로, 데몬 스레드 역시 자동으로 종료됩니다.

데몬 스레드의 생성 방법과 실행 방법은 모두 일반 스레드와 같습니다.

단, 실행하기 전에 setDaemon() 메소드를 호출하여 데몬 스레드로 설정하기만 하면 됩니다.

이러한 데몬 스레드는 일정 시간마다 자동으로 수행되는 저장 및 화면 갱신 등에 이용되고 있습니다.

데몬 스레드를 이용하는 가장 대표적인 예로 가비지 컬렉터(gabage collector)를 들 수 있습니다.

가비지 컬렉터(gabage collector)란 프로그래머가 동적으로 할당한 메모리 중 더 이상 사용하지 않는 영역을 자동으로 찾아내어 해제해 주는 데몬 스레드입니다.
 */

public class Thread03 {
    public static void main(String[] args) {
        Thread thread0 = new Thread(new ThreadWithRunnable());
        thread0.start();
        System.out.println(thread0.getThreadGroup());

        ThreadGroup group = new ThreadGroup("myThread"); // 그룹 생성
        group.setMaxPriority(7); // 우선순위를 7로 설정

        Thread thread1 = new Thread(group, new ThreadWithRunnable());
        thread1.start();
        System.out.println(thread1.getThreadGroup());

    }
}
