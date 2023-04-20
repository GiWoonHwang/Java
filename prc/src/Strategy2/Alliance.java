package Strategy2;

public class Alliance extends Character implements Ride {
    public void riding(){
        if(level == 40){
            System.out.println("Alliance로 생성한 " + name + " 직업 " + job + " 레벨 " + level + " 는 60% 속도의 라이딩을 탑니다");
        }
        else if(level == 60) {
        System.out.println("Alliance로 생성한" + name + " 직업 " + job + " 레벨 " + level + " 는 120% 속도의 라이딩을 탑니다 ");
        }
    }
}