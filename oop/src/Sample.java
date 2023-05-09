///*
//난 동물원의 사육사이다.
//육식동물이 들어오면 난 먹이를 던져준다.
//호랑이가 오면 사과를 던져준다.
//사자가 오면 바나나를 던져준다.
// */
//
//interface Predator {
//    String getFood();
//
//    default void printFood() {
//        System.out.printf("my food is %s\n", getFood());
//    }
//
//    int LEG_COUNT = 4;  // 인터페이스 상수
//
//    static int speed() {
//        return LEG_COUNT * 30;
//    }
//}
//
//interface Barkable {
//    void bark();
//}
//
//interface BarkablePredator extends Predator, Barkable {
///*
//여기서 알아두어야 할 사항은 Predator 로 선언된 predator 객체와 Barkable 로 선언된 barkable 객체는 사용할 수 있는 메서드가 서로 다르다는 점이다.
//predator 객체는 getFood() 메서드가 선언된 Predator 인터페이스의 객체이므로 getFood 메서드만 호출이 가능하다.
//이와 마찬가지로 Barkable 로 선언된 barkable 객체는 bark 메서드만 호출이 가능하다.
//
//만약 getFood 메서드와 bark 메서드를 모두 사용하고 싶다면 어떻게 해야 할까?
//
//Predator, Barkable 인터페이스를 구현한 Tiger 로 선언된 tiger 객체를 그대로 사용하거나 다음과 같이 getFood, bark 메서드를 모두 포함하는 새로운 인터페이스를 새로 만들어 사용하면 된다.
//
//
// */
//}
//
//class Animal {
//    String name;
//
//    void setName(String name){
//        this.name = name;
//    }
//}
//
///*
//Tiger tiger = new Tiger();  // Tiger is a Tiger
//Animal animal = new Tiger();  // Tiger is a Animal
//Predator predator = new Tiger();  // Tiger is a Predator
//Barkable barkable = new Tiger();  // Tiger is a Barkable
//
//tiger, lion 객체는 각각 Tiger, Lion 클래스의 객체이면서 Animal 클래스의 객체이기도 하고 Barkable, Predator 인터페이스의 객체이기도 하다.
//이러한 이유로 barkAnimal 메서드의 입력 자료형을 Animal에서 Barkable 로 바꾸어 사용할 수 있는 것이다.
//이렇게 하나의 객체가 여러개의 자료형 타입을 가질 수 있는 것을 객체지향 세계에서는 다형성(Polymorphism)이라고 한다.
// */
//class Tiger extends Animal implements Predator, Barkable {
//    public String getFood() { // 인터페이스의 메서드는 항상 public으로 구현해야 한다.
//        return "apple";
//    }
//
//    public void bark() {
//        System.out.println("어흥");
//    }
//}
//
//class Lion extends Animal implements  BarkablePredator {
//    public String getFood() {
//        return "banana";
//    }
//
//    public void bark() {
//        System.out.println("으르렁");
//    }
//
//}
//
//class ZooKeeper{
//    void feed(Predator predator){
//        System.out.println("feed "+ predator.getFood());
//    }
//
//    void feed(Lion lion){
//        System.out.println("feed banana");
//     }
//
//     /*
//     동물원에 호랑이와 사자뿐이라면 ZooKeeper 클래스는 더 이상 할일이 없겠지만 악어, 표범 등이 계속 추가된다면 ZooKeeper는 육식동물이 추가될 때마다 매번 다음과 같은 feed 메서드를 추가해야 한다.
//
//     public void feed(Crocodile crocodile) {
//         System.out.println("feed strawberry");
//     }
//
//    public void feed(Leopard leopard) {
//        System.out.println("feed orange");
//    }
//     */
//
//}
//
//class Bouncer {
//    void barkAnimal(Barkable animal){
//        animal.bark();
//
//    }
//}
//
//
//
//
//public class Sample {
//    public static void main(String[] args){
//        ZooKeeper zooKeeper = new ZooKeeper();
//        Tiger tiger = new Tiger();
//        Lion lion = new Lion();
//
////        zooKeeper.feed(tiger);
////        zooKeeper.feed(lion);
//
//        Bouncer bouncer= new Bouncer();
//        bouncer.barkAnimal(tiger);
//        bouncer.barkAnimal(lion);
//
//
//
//
//    }
//
//
//}
