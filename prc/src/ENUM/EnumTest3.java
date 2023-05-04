package ENUM;

import java.util.Arrays;
import java.util.function.Function;
import java.math.BigDecimal;;
public enum EnumTest3 {

    LEVEL_ONE("one", gold -> BigDecimal.valueOf(0.5).multiply(gold)),

    LEVEL_TWO("two", gold -> BigDecimal.valueOf(2).multiply(gold)),

    LEVEL_THREE("three", gold -> BigDecimal.valueOf(4).multiply(gold));

    /** enum code */
    public String code;

    /** functional interface를 활용하자 */
    private Function<BigDecimal, BigDecimal> expression;

    /** String, Function type constructor */
    EnumTest3(String code, Function<BigDecimal, BigDecimal> expression) {
        this.code = code;
        this.expression = expression;
    }

    /**
     * functional interface의 abstract Method를 통해서 계산을 처리해서 리턴하자.
     * @param gold
     * @return BigDecimal
     */
    public BigDecimal rewardGold(BigDecimal gold) {
        return expression.apply(gold);
    }

    /**
     * get Enum Object from code
     * @param code
     * @return ThirdEnum
     */
    // 코드로 열거값을 찾는거/
    public static EnumTest3 fromString(String code) {
        return Arrays.asList(EnumTest3.values())
                .stream()
                .filter( thirdEnum -> thirdEnum.code.equalsIgnoreCase(code) )
                .map(thirdEnum -> thirdEnum)
                .findFirst().orElse(null);
    }

}
