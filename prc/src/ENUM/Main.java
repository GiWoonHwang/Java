package ENUM;
import java.math.BigDecimal;
import java.util.stream.Stream;

import static ENUM.EnumTest.LEVEL_ONE;

public class Main {
    public static void main(String [] args) {
//        System.out.println(LEVEL_ONE.name());
//        System.out.println(EnumTest.LEVEL_TWO.name());
//        System.out.println(EnumTest.LEVEL_THREE.name());
//
//        System.out.println(LEVEL_ONE.ordinal());
//        System.out.println(EnumTest.LEVEL_TWO.ordinal());
//        System.out.println(EnumTest.LEVEL_THREE.ordinal());
//
//        Stream.of(EnumTest.values()).forEach(enumTest -> System.out.println(enumTest.name()));
//
//
//// 상수를 정의해서 쓴다는 개념이 있어 switch문과 궁합이 잘 맞는다. 하지만 if문과의 차이를 모르겠다.
//        EnumTest level = LEVEL_ONE;
//
//        switch (level) {
//            case LEVEL_ONE:
//                System.out.println("level 1");
//                break;
//            case LEVEL_TWO:
//                System.out.println("level 2");
//                break;
//            case LEVEL_THREE:
//                System.out.println("level 3");
//                break;
//            default:
//                System.out.println("nothing");
//                break;
//        }
//
//        System.out.println(EnumTest2.LEVEL_ONE.code);
//        System.out.println(EnumTest2.LEVEL_ONE.index);
//
//        // 코드값으로 enum을 가져온다
//        System.out.println(EnumTest2.LEVEL_ONE.code);
//        System.out.println(EnumTest2.LEVEL_ONE.index);
//        System.out.println(EnumTest2.fromString("one"));

        /*
        * enum을 통해 캡슐화
        * 시나리오
        * 1.DB또는 무엇이 되었든 특정 퀘스트를 완료하게 돼 현재 어떤 게임 유저의 레벨과 가지고 있는 골드에 대한 특정 배수만큼 곱한 골드를 지급한다.
        * */
        int userGold = 1000;
        int rewardGold = 0;

        // 현재 유저의 레벨
        EnumTest2 level = EnumTest2.LEVEL_ONE;

        // 전통적인 방식
        switch(level) {
            case LEVEL_ONE:
                rewardGold = userGold * 2;
                System.out.println("level 1");
                break;
            case LEVEL_TWO:
                rewardGold = userGold * 3;
                System.out.println("level 2");
                break;
            case LEVEL_THREE:
                rewardGold = userGold * 4;
                System.out.println("level 3");
                break;
            default:
                rewardGold = userGold;
                System.out.println("nothing");
                break;

        }

        // 현재 유저가 가지고 있는 골
        BigDecimal gold = BigDecimal.valueOf(100);

        // 레벨에 따른 보상 골드를 가져와 보자.
        System.out.println(EnumTest3.LEVEL_ONE.rewardGold(gold));
        System.out.println(EnumTest3.fromString("one").rewardGold(gold));

        System.out.println(EnumTest3.LEVEL_TWO.rewardGold(gold));
        System.out.println(EnumTest3.fromString("two").rewardGold(gold));

        System.out.println(EnumTest3.LEVEL_THREE.rewardGold(gold));
        System.out.println(EnumTest3.fromString("three").rewardGold(gold));



    }
}