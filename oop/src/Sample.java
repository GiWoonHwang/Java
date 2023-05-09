/*
난 동물원의 사육사이다.
육식동물이 들어오면 난 먹이를 던져준다.
호랑이가 오면 사과를 던져준다.
사자가 오면 바나나를 던져준다.
 */

interface Predator {
    String getFood();

    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }

    int LEG_COUNT = 4;  // 인터페이스 상수

    static int speed() {
        return LEG_COUNT * 30;
    }


}

class Animal {
    String name;

    void setName(String name){
        this.name = name;
    }
}

class Tiger extends Animal implements Predator {
    public String getFood() { // 인터페이스의 메서드는 항상 public으로 구현해야 한다.
        return "apple";
    }
}

class Lion extends Animal implements  Predator {
    public String getFood() {
        return "banana";
    }

}

class ZooKeeper{
    void feed(Predator predator){
        System.out.println("feed "+ predator.getFood());
    }

    void feed(Lion lion){
        System.out.println("feed banana");
     }

     /*
     동물원에 호랑이와 사자뿐이라면 ZooKeeper 클래스는 더 이상 할일이 없겠지만 악어, 표범 등이 계속 추가된다면 ZooKeeper는 육식동물이 추가될 때마다 매번 다음과 같은 feed 메서드를 추가해야 한다.

     public void feed(Crocodile crocodile) {
         System.out.println("feed strawberry");
     }

    public void feed(Leopard leopard) {
        System.out.println("feed orange");
    }
     */

}




public class Sample {
    public static void main(String[] args){
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);




    }


}
