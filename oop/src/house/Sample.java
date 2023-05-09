package house;

class Singleton {
    private static Singleton one;
    /*
    싱글톤은 단 하나의 객체만을 생성하게 강제하는 패턴이다. 즉 클래스를 통해 생성할 수 있는 객체는 Only One, 즉, 한 개만 되도록 만드는 것이 싱글톤이다.
     */
    private Singleton() {

    }

    public static Singleton getInstance() {
        if(one == null){
            one = new Singleton();
        }
        return one;

//        return new Singleton(); // 같은 클래스이므로 생성자 호출이 가능하다
    }
}

class HouseLee {
    /*
    lastname 변수에 static 키워드를 붙이면 자바는 메모리 할당을 딱 한번만 하게 되어 메모리 사용에 이점이 있다.
    static을 사용하는 또 한가지 이유로 공유 개념을 들 수 있다. static 으로 설정하면 같은 곳의 메모리 주소만을 바라보기 때문에 static 변수의 값을 공유하게 되는 것이다.
     */
    static String lastname = "이";
}

class Counter {
    static int count = 0; // static으로 count 값을 공유시킨다.
    Counter() {
        this.count ++;
        System.out.println(this.count);
    }

    /*
    보통 스태틱 메서드는 유틸리티성 메서드를 작성할 때 많이 사용된다. 예를 들어 "오늘의 날짜 구하기", "숫자에 콤마 추가하기" 등의 메서드를 작성할 때에는 클래스 메서드를 사용하는 것이 유리하다.
     */
    public static int getCount() {
        return count;
    }
}

public class Sample {
    public static void main(String[] args){
        /*
        이씨 집안을 나타내는 HouseLee 클래스이다. 위와 같은 클래스를 만들고 객체를 생성하면 객체마다 객체변수 lastname을 저장하기 위한 메모리가 별도로 할당된다.
        하지만 가만히 생각해 보면 HouseLee 클래스의 lastname은 어떤 객체이던지 동일한 값인 "이" 이어야 할 것 같지 않은가?
        이렇게 항상 값이 변하지 않는 경우라면 static 사용시 메모리의 이점을 얻을 수 있다.
         */
        HouseLee lee1 = new HouseLee();
        HouseLee lee2 = new HouseLee();

        /*
        c1, c2 객체 생성시 생성자에서 객체변수인 count의 값을 1씩 증가하더라도 c1과 c2의 count는 서로 다른 메모리를 가리키고 있기 때문에 원하던 결과(카운트가 증가된 결과)가 나오지 않는다.
        객체변수는 항상 독립적인 값을 갖기 때문에 당연한 결과이다.
         */
        Counter c1 = new Counter();
        Counter c2 = new Counter();

//        Singleton singleton = new Singleton(); // Singleton 클래스의 생성자에 private 키워드로 다른 클래스에서 Singleton 클래스의 생성자로의 접근을 막아 컴파일 오류가 난다. -> new를 통해 생성할 수 없음

//        Singleton singleton = Singleton.getInstance(); // 객체 생성이 가능하다. 하지만 getInstance를 호출할 때마다 새로운 객체가 생성된다. 그렇다면 싱글톤이 아니다.

        /*
        최초 getInstance가 호출 되면 one이 null이므로 new에 의해서 객체가 생성이 된다. 이렇게 한번 생성이 되면 one은 static 변수이기 때문에 그 이후로는 null이 아니게 된다.
        그런 후에 다시 getInstance 메서드가 호출되면 이제 one은 null이 아니므로 이미 만들어진 싱글톤 객체인 one을 항상 리턴한다.
        main 메서드에서 getInstance를 두번 호출하여 각각 얻은 객체가 같은 객체인지 조사 해 보았다. 역시 예상대로 "true"가 출력되어 같은 객체임을 확인 할 수 있다.
         */
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);  // true 출력
    }
}
