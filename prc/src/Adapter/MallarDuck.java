package Adapter;

public class MallarDuck implements Duck {
    public void quack() {
        System.out.println("꽥, 꽥");
    }

    public void fly() {
        System.out.println("먼 거리를 날아 갈 수 있습니다.");
    }
}
