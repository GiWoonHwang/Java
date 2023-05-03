package ENUM;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;

public enum EnumTest2 {
    // 클래스처럼 생성자와 열거형에 각 각의 타입을 명시적으로 작성해서 명확하게 사용하기 시작
    LEVEL_ONE("one", 0),

    LEVEL_TWO("two", 1),

    LEVEL_THREE("three", 2);

    public String code;
    public int index;

    EnumTest2(String code, int index){
        this.code = code;
        this.index = index;
    }

    /*
    스트링 타입의 코드 값으로 enum을 가져오고 싶은 경우가 발생하기도 한다.
    그래서 다음과 같이 values()함수를 이용해서 넘겨받은 코드값으로 해당 객체를 가져오는 코드를 추가 했다.
    * */
    public static EnumTest2 fromString(String code){
        return Arrays.asList(EnumTest2.values())
                .stream()
                .filter( secondEnum -> secondEnum.code.equalsIgnoreCase(code) )
                .map(secondEnum -> secondEnum)
                .findFirst().orElse(null);
    }
}
