package Isp;

public class Galaxy1 implements SmartPhone, Galaxy1Function{
    public String telePhone(){
        return "전화를 건다.";
    }

    public String mp3(){
        return "mp3를 연결한다.";
    }

    public String internet(){
        return "인터넷을 연결한다.";
    }
}
