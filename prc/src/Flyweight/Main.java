package Flyweight;

import java.util.Scanner;

/*
싱글톤 패턴과 차이는 ?

우리가 제작한 Flyweight 패턴에서,
나무는 색깔이 바뀔 때 새로운 객체를 생성합니다.
색상 별로 하나씩, 결과적으로는 여러개의 나무가 생깁니다.
또한 만들어진 객체의 색상은 바꿀 수 없는 일입니다.
따라서 하나씩 여러종류를 가질 수 있습니다.

그러나 싱글톤 패턴이라면,
나무 클래스에 단 한개의 나무만 만들수 있습니다.
따라서 싱글톤 패턴을 사용한다면,
만들어진 단 하나의 객체(나무)의 색깔을 바꿔야만합니다.
싱글톤은 이렇듯 하나의 클래스에 단 하나의 인스턴스를 생성하고, 대신 변수를 필요시 변경해가며 쓸 수 있다는 차이가 있습니다.
따라서 싱글톤 패턴은 종류 상관없이 단 하나만 가질 수 있습니다.
* */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("원하는 색을 입력해주세요 : ");
        for(int i = 0; i < 10; i ++){
            //나무 색 입력받기
            String input = scanner.nextLine();
            // 팩토리에서 나무 하나 공급받기
            Tree tree = (Tree)TreeFactory.getTree(input);
            //나무 x,y 설정하고
            tree.setX((int) (Math.random()*100));
            tree.setY((int) (Math.random()*100));
            //나무 설치하기
            tree.install();
        }
    }
}
