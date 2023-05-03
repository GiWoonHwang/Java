package ENUM;

import static ENUM.EnumTest2;

public class CommonUtils {
    /**
     * reward gold
     *
     * @param userGold (유저가 소지한 골드)
     * @param level (유저의 레벨)
     * @throws JsonProcessingException
     */
    public static int rewardGold(int userGold, Level level ) {
        int rewardGold = 0;
        switch(level) {
            case EnumTest2.LEVEL_ONE:
                rewardGold = userGold * 2;
                System.out.println("level 1");
                break;
            case EnumTest2.LEVEL_TWO:
                rewardGold = userGold * 3;
                System.out.println("level 2");
                break;
            case EnumTest2.LEVEL_THREE:
                rewardGold = userGold * 4;
                System.out.println("level 3");
                break;
            default:
                rewardGold = userGold;
                System.out.println("nothing");
                break;

        }
        return rewardGold;
    }
}
