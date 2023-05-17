package Thread;

class ThreadWithClass extends Thread {

    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println(getName()); // 현재 실행 중인 스레드의 이름을 반환함.

            try {

                Thread.sleep(10);          // 0.01초간 스레드를 멈춤.

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}
