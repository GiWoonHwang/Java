package Creating_and_destroying_objects;

public class Static_Factory_Method {
    /*
    정적 팩토리 메서드: 그 클래스의 인스턴스를 반환하는 단순한 메서드
    장점
    1. 이름을 가질 수 있다.
    2. 호출될 때마다 인스턴스를 새로 생설하지는 않아도 된다.
    3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반활할 수 있다.
    5. 정적 팩터리 메서드를 작성하는 시점에는 반활할 객체의 클래스가 존재하지 않아도 된다.

    단점
    1. 상속을 하려면 public이나 protect 생성자가 필요하니 정적 패터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
    2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.
     */
    public static Boolean valueOf(boolean b){
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
