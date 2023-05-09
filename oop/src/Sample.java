class Animal {
    String name;

    void setName(String name){
        this.name = name;
    }
}

class Dog extends Animal { // Animal 클래스를 상속한다
    Dog() { // 아무 내용이 없으면 디폴트 생성자라고 한다.

    }
    /*
    * Dog 클래스에 name 이라는 객체변수와 setName 이라는 메서드를 만들지 않았지만 Animal 클래스를 상속했기 때문에 예제이서 보듯이 그대로 사용이 가능하다.
    * Dog 클래스는 Animal 클래스를 상속했다. 즉, Dog는 Animal의 하위 개념이라고 할 수 있다. 이런 경우 Dog는 Animal에 포함되기 때문에 "개는 동물이다"라고 표현할 수 있다. 자바는 이러한 관계를 IS-A 관계라고 표현한다.
    * */
    void sleep() {
        System.out.println(this.name +"   zzzz");
    }

}

class HouseDog extends Dog {
    HouseDog(String name){ // name 이라는 객체변수에 값을 무조건 설정해야만 객체가 생성될 수 있도록 강제할 수 있는 방법 1. 클래스명과 메서드명이 동일하다 2. 리턴타입을 정의하지 않는다ㄴ
        this.name = name;
    }

    // 생성자 오버로딩
    HouseDog(int type){
        if (type == 1){
            this.setName("yorkshire");
        }
        else if (type == 2){
            this.setName("bulldog");
        }
    }

    void sleep() {
        System.out.println(this.name + " zzz in house"); // 부모클래스의 메서드를 자식클래스가 동일한 형태로 또다시 구현하는 행위를 메서드 오버라이딩
    }

    void sleep(int hour){
        System.out.println(this.name+" zzz in house for " + hour + " hours"); // 오버로딩
    }
}


public class Sample {
    public static void main(String[] args){
        HouseDog happy = new HouseDog("happy"); // 문자열로 객체 생성
        HouseDog yorkshire = new HouseDog(1); // 숫자값으로 객체 생성

        System.out.println(happy.name);
        System.out.println(yorkshire.name);

    }


}
