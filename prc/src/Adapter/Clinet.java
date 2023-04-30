package Adapter;

public class Clinet {
    public static void main(String[] args) {
        System.out.println("칠면조가 웁니다.");
        WildTurkey turkey = new WildTurkey();
        turkey.gobble();
        turkey.fly();

        System.out.println("칠면조 어댑터가 웁니다.");
        Duck turkeyAdpater = new TurkeyAdapter(turkey);
        turkeyAdpater.quack();
        turkeyAdpater.fly();

        System.out.println("오리가 웁니다.");
        MallarDuck duck = new MallarDuck();
        duck.quack();
        duck.fly();

    }
}
