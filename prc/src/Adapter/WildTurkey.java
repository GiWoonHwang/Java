package Adapter;

public class WildTurkey implements Turkey {
    public void gobble() {
        System.out.println("고르륵 고르륵");
    }

    public void fly() {
        System.out.println("짧은 거리만 날아 갈 수 있습니다.");
    }

}
