package Strategy;

public class Lg implements Functionable{
    public void answerThePhone(){
        System.out.println("단종된 휴대폰으로 전화를 받습니다");
    }

    public void makePhoneCall(){
        System.out.println("단종된 휴대폰으로 전화를 겁니다");
    }
}
