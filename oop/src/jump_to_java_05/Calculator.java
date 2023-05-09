package jump_to_java_05;

public class Calculator {
    int result = 0;

    int add(int num){
        result += num;
        return result;
    }

    int sub(int num){
        result -= num;
        return result;
    }

}

// 계산기가 늘어날 때 마다 클래스를 추가할 것인가 ?
//public class Calculator2 {
//    static int result = 0;
//
//    static int add(int num){
//        result += num;
//        return result;
//    }
//}