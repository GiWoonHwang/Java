package Thread;

class ThreadWithRunnable implements Runnable {

    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()); // 현재 실행 중인 스레드의 이름을 반환함.

            try {

                Thread.sleep(10);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}
