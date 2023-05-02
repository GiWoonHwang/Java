package Flyweight;

public class Tree {
    private String color;
    private int x;
    private int y;

    // 색상으로만 생성자를 만들어 준다
    public Tree(String color){
        this.color = color;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    //나무를 심을 때
    public void install(){
        System.out.println("x:"+x+" y:"+y+" 위치에 "+color+"색 나무를 설치했습니다!");
    }


}
