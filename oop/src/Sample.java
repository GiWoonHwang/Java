class Animal {
    String name;

    void setName(String name){
        this.name = name;
    }
}

class Dog extends Animal { // Animal 클래스를 상속한다
    /*
    * Dog 클래스에 name 이라는 객체변수와 setName 이라는 메서드를 만들지 않았지만 Animal 클래스를 상속했기 때문에 예제이서 보듯이 그대로 사용이 가능하다.
    * Dog 클래스는 Animal 클래스를 상속했다. 즉, Dog는 Animal의 하위 개념이라고 할 수 있다. 이런 경우 Dog는 Animal에 포함되기 때문에 "개는 동물이다"라고 표현할 수 있다. 자바는 이러한 관계를 IS-A 관계라고 표현한다.
    * */
    void sleep() {
        System.out.println(this.name +"   zzzz");
    }

}

class HouseDog extends Dog {
    // 집에서 키우는 개들은 집에서만 잠을 잔다고 한다
    void sleep() {
        System.out.println(this.name + " zzz in house"); // 부모클래스의 메서드를 자식클래스가 동일한 형태로 또다시 구현하는 행위를 메서드 오버라이딩
    }

    void sleep(int hour){
        System.out.println(this.name+" zzz in house for " + hour + " hours");
    }
}


public class Sample {
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.setName("poppy");

        System.out.println(dog.name);
        dog.sleep();


        Animal giwoon = new Dog(); // Dog객체를 Animal 자료형으로 사용할 경우에는 Dog 클래스에만 존재하는 sleep 메서드를 사용할 수 없다는 점이다, 개로 만든 객체는 동물 자료형이다.
//        Dog dog = new Animal(); // 컴파일 오류: 부모 클래스로 만든 객체는 자식 클래스의 자료형으로 사용할 수 없다.

        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        houseDog.sleep();  // happy zzz 출력
        houseDog.sleep(3);  // happy zzz in house for 3 hours 출력
    }


}
