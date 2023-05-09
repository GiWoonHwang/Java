class FoolException extends Exception{
    /*
    RuntimeException은 실행시 발생하는 예외이고 Exception은 컴파일시 발생하는 예외이다. 즉, Exception은 프로그램 작성시 이미 예측가능한 예외를 작성할 때 사용하고
    RuntimeException은 발생 할수도 발생 안 할수도 있는 경우에 작성한다. 그래서 Exception을 Checked Exception, RuntimeException을 Unchecked Exception 이라고도 한다.
     */

}

public class Sample {
    public void sayNick(String nick) throws FoolException {
        if("fool".equals(nick)) {
            throw new FoolException();
        }
        System.out.println("당신의 별명은 "+nick+" 입니다.");
    }

    public static void main(String[] args){
        Sample sample = new Sample();
        try {
            sample.sayNick("fool");
            sample.sayNick("genious");
        } catch (FoolException e) {
            System.err.println("FoolException이 발생했습니다.");
        }

    }
}
