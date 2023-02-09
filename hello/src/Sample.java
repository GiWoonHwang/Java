
import java.util.ArrayList;
import java.util.Arrays;
public class Sample {
    public static  void main(String[] args){
        // int i = 0;
        // System.out.println(i++); // 문장이 실행된 이후에 증가
        // System.out.println(i);
        // System.out.println(++i); // 실행되기 전에 증가
        // System.out.println(i++);
        // int base = 180;  // 리터럴표가: 객체생성 없이 고정된 값을 그대로 대입하는 방법
        // int height = 185;
        // char a1 = 'a';  // 문자로 표현
        // char a2 = 97;  // 아스키코드로 표현
        // char a3 = '\u0061';  // 유니코드로 표현
        
        // String a = "'happy java'"; // 문자열을 jvm의 intern pool 이라는 메모리 공간에 저장하고 다음에 다시 동일 한 문자열이 선언될때 cache된 문자열을 리턴
        // String a_0 = new String("Happy Java"); // 항상 새로운 객체를 생성
        // String b = "a";
        // String c = "123";

        // System.out.println(a.equals(b));

        // String a = "hello";
        // String b = new String("hello");
        // System.out.println(a.equals(b));  // true
        // System.out.println(a == b);  // false 값은 같지만 서로 다른 객체이기 때문이다. ==는 두 개의 자료형이 동일한 객체인지를 판변할 때 사용한다.
        
        // String a = "hello java";
        // System.out.println(a.replaceAll("java","park"));
    
        // String a = "hello java";
        // System.out.println(a.substring(0,4));    
        
        // System.out.println(String.format("i eat %d apples",3));
    
        // int number = 10;
        // String day = "three";

        // System.out.println(String.format("i atd %d apples. so i was sick for %s days",number, day));
    
    
        // StringBuffer sb = new StringBuffer(); // 객체는 한번만 생성된다. -- > 기존값을 ㅏㅂ꾼다 ?
        // sb.append("hello");
        // sb.append(" ");
        // sb.append("jump to java");
        // String result = sb.toString();
        // System.out.println(result);


        // 연산이 있을때마다 객체가 생성된다. 따라서 총 4개,  
        // trim, toUpperCase 등의 메서드를 보면 문자열이 변경되는 것 처럼 생각 될 수도 있지만 해당 메서드 수행 시 또 다른 String 객체를 생성하여 리턴할 뿐이다. --> 새로운 객체를 생성할 때마다 메모리를 먹는다 ?
        // String result = ""; 
        // result += "hello";
        // result += " ";
        // result += "jump to java";
        // System.out.println(result);  // "hello jump to java" 출력
    
        /*
         그건 상황에 따라 다르다. StringBuffer 자료형은 String 자료형보다 무거운 편에 속한다. new StringBuffer() 로 객체를 생성하는 것은 일반 String을 사용하는 것보다 메모리 사용량도 많고 속도도 느리다.
        따라서 문자열 추가나 변경 등의 작업이 많을 경우에는 StringBuffer를, 문자열 변경 작업이 거의 없는 경우에는 그냥 String을 사용하는 것이 유리하다.
         결론: 계속 바꿔야함 -> stringbuffer, 변경없음 -> string

         */
    
        /*
        StringBuilder
        Stri       ngBuffer와 비슷한 자료형으로 StringBuilder가 있다. StringBuilder의 사용법은 StringBuffer의 사용법과 동일하다.
                
        Stri       ngBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String result = sb.toString();
        System.out.println(result);
        StringBuffer는 멀티 스레드 환경에서 안전하다는 장점이 있고 StringBuilder는 StringBuffer보다 성능이 우수한 장점이 있다. 따라서 동기화를 고려할 필요가 없는 상황에서는 StringBuffer 보다는 StringBuilder를 사용하는 것이 유리하다.
        */

        // int[] odds = {1,3,5,7,9};
        // String[] weeks = {"월","화","수","목","금","토","일"};
        // String[] weeks = new String[7]; // 배열의 길이를 먼저 설정하여 대입하는 부분
        // weeks[0] = "월";
        // weeks[1] = "화";
        // weeks[2] = "수";
        // weeks[3] = "목";
        // weeks[4] = "금";
        // weeks[5] = "토";
        // weeks[6] = "일";

        // for(int i = 0; i <weeks.length; i++){
        //     System.out.println(weeks[i]);
        // }
        
        // 리스트 List. 배열과 다르게 크기를 미리 지정하지 않아도 된다.
        // ArrayList pitches = new ArrayList();
        
        // pitches.add("138");
        // pitches.add("128");
        // pitches.add("111");
        // System.out.println(pitches.contains("111"));

        /*
        remove 메서드에는 2가지 방식이 있다. (이름은 같지만 입력파라미터가 다르다)

        remove(객체)
        remove(인덱스)
        첫번째 remove(객체)의 경우는 리스트에서 객체에 해당되는 항목을 삭제하고 삭제한 결과(true, false)를 리턴한다.
         */
        // System.out.println(pitches.remove("129")); // true
        // System.out.println(pitches.remove(0)); // 인덱스에 해당하는 값
        
        // String[] data = {"123","123","412"};
        // ArrayList<String> pitches = new ArrayList<>(Arrays.asList(data));
        // System.out.println(pitches);
    
        // ArrayList<String> pitches = new ArrayList<>(Arrays.asList("123","312","123"));
        // String result = "";
        // for(int i = 0; i < pitches.size(); i++){
        //     result += pitches.get(i);
        //     result += ",";
        // }
        // result = result.substring(0, result.length()-1);
        // System.out.println(result);
        
        // ArrayList<String> pitches = new ArrayList<>(Arrays.asList("143","123","333"));
        // // String.join("구분자", 리스트객체)와 같이 사용하여 리스트의 각 요소에 "구분자"를 삽입하여 하나의 문자열로 만들 수 있다.
        // String result = String.join("1", pitches);
        // System.out.println(result);

        
    
    
    
    
    }
    
}
 