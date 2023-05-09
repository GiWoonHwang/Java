package house.person; // HousePark 과 패키지가 서로 다르다.

import house.HousePark;

public class EungYongPark extends HousePark {
    public static void main(String[] args) {
        EungYongPark eyp = new EungYongPark();
        HousePark housePark = new HousePark();
        System.out.println(eyp.lastname); // 상속한 클래스의 protected 변수는 접근이 가능하다.
        System.out.println(housePark.info);
    }
}
