class Animal{
    String name; // 객체변수

    public void setName(String name){
        this.name = name;
    }

}
public class Sample {
    int e;
    int varTest(int d){ // 외부의 d 값을 증가시키는 방법
        d++;
        return d;
    }

    void sayNick(String nick){
        if("fool".equals(nick)){
            return ;
        }
        System.out.println("나의 별명은 "+nick+" 입니다." );
    }
    int sum(int a, int b){
        return a + b;
    }
    public static void main(String[] args){
//    int a = 3;
//    int b = 4;
//
    Sample sample = new Sample(); // 작성한 클래스를 단독으로 실행시켜 테스트할 때 자주 사용하는 방법이다.
//    int c = sample.sum(a,b);s
//    System.out.println(c); // 7
//
//    sample.sayNick("angel");
//    sample.sayNick("fool");  // 출력되지 않는다.

    int d = 1;

    d = sample.varTest(d);
    sample.e = 1;
    sample.varTest(sample.e);
    System.out.println(d); // 2
    System.out.println(sample.e); // 2








    }


}
