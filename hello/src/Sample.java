
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
public class Sample {
    // Enum은 서로 관련이 있는 여러 개의 상수 집합을 정의할 때 사용하는 자료형이다.
    // 매직넘버(1과 같은 숫자 상수값)를 사용할 때보다 코드가 명확해 진다.
    // 잘못된 값을 사용함으로 인해 발생할수 있는 위험성이 사라진다.
    // enum CoffeeType{
    //     AMERICANO,
    //     ICE_AMERICANO,
    //     CAFE_LATTE
    // };


    public static  void main(String[] args){
        // System.out.println(CoffeeType.AMERICANO);
        // System.out.println(CoffeeType.ICE_AMERICANO);
        // System.out.println(CoffeeType.CAFE_LATTE);

        // for(CoffeeType type: CoffeeType.values()){
        //     System.out.println(type);
        // }
        






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
        

        // ArrayList<String> pitches = new ArrayList<>(Arrays.asList("123","414","321"));
        // pitches.sort(Comparator.naturalOrder()); // Comparator.reverseOrder() 내림차순
        // System.out.println(pitches);
    
        /*
         * 
         * "사람"을 예로 들면 누구든지 "이름" = "홍길동", "생일" = "몇 월 며칠" 등으로 구분할 수 있다. 자바의 맵(Map)은 이러한 대응관계를 쉽게 표현할 수 있게 해 주는 자료형이다. 이것은 요즘 나오는 대부분의 언어들도 갖고 있는 자료형으로 Associative array, Hash라고도 불린다.

            맵(Map)은 사전(dictionary)과 비슷하다. 즉, people 이란 단어에 "사람", baseball 이라는 단어에 "야구"라는 뜻이 부합되듯이 Map은 Key와 Value를 한 쌍으로 갖는 자료형이다.

            key	value
            people	사람
            baseball	야구
            Map은 리스트나 배열처럼 순차적으로(sequential) 해당 요소 값을 구하지 않고 key를 통해 value를 얻는다. 맵(Map)의 가장 큰 특징이라면 key로 value를 얻어낸다는 점이다. baseball이란 단어의 뜻을 찾기 위해서 사전의 내용을 순차적으로 모두 검색하는 것이 아니라 baseball이라는 단어가 있는 곳만을 펼쳐보는 것이다.
         * 
         */
        
        //  HashMap<String, String>map = new HashMap<>();
        //  map.put("people","사람");
        //  map.put("baseball","야구");
        
        //  System.out.println(map.keySet()); // 모든 key를 모아서 set로 리턴한다
        
         /*
          * 
          map의 가장 큰 특징은 순서에 의존하지 않고 key로 value를 가져온다
          LinkedHashMap은 입력된 순서대로 데이터를 저장하는 특징을 가지고 있다.
          TreeMap은 입력된 key의 오름차순 순서로 데이터를 저장하는 특징을 가지고 있다.
          */
        
        // 중복을 허용하지 않으며 순서가 없다.
        // HashSet<String> set = new HashSet<>(Arrays.asList("1","2","3","4"));
        // System.out.println(set);
        
        // HashSet<Integer>s1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        // HashSet<Integer>s2 = new HashSet<>(Arrays.asList(4,5,6,7,8));
        
        // HashSet<Integer> intersection = new HashSet<>(s1); // s1으로 intersaction 생성 만약 retainAll 메서드를 사용하면 s1의 내용이 변경될 것이다.
        // intersection.retainAll(s2);
        // System.out.println(intersection);
        
        // HashSet<Integer> union = new HashSet<>(s1);
        // union.addAll(s2);

        // HashSet<Integer> substract = new HashSet<>(s1);  // s1으로 substract 생성
        // substract.removeAll(s2); // 차집합 수행
        // System.out.println(union);  // [1, 2, 3, 4, 5, 6, 7, 8, 9] 출력

        // HashSet<String> set = new HashSet<>();
        // set.add("ddd");
        // set.addAll(Arrays.asList("null","Ddd"));
        // set.remove("To");
        
        // String num = "123";
        // int n = Integer.parseInt(num);
        // System.out.println(n);  // 123 출력 문자열을 숫자로 바꾸어 준다.

        // int n = 123;
        // String num = "" + n;
        // System.out.println(num);
        // String num1 = String.valueOf(n);
        // String num2 = Integer.toString(n);
        // System.out.println(num1);  // 123 출력
        // System.out.println(num2);  // 123 출력
        
        // String num = "123.456";
        // double d = Double.parseDouble(num); // "실수형 문자열을 실수로 바꾸어 준다."

        // // 실수를 정수로 바꿀 때에는 캐스팅이 필요 없지만 정수 -> 실수는 캐스팅이  필요하다.
        // double d2 = 123.241;
        // int n2 = (int) d2; // 자료형을 강제로 변한한다.
        // System.out.println(n2);

        // final int n = 123;
        // n = 456; // 값 변경이 불가능하다 
        // System.out.println(n);
        
        // final ArrayList<String> a = new ArrayList<>(Arrays.asList("a","b")); // 배열도 재할당 불가능
        
        // int a = 29;
        // int b = 50;
        // int c = 55;

        // System.out.println((a+b+c)/3);

        // String pin = "123456-1234567";
        // String yyyyMMdd = pin.substring(0,6);
        // String num = pin.substring(7);

        // System.out.println(yyyyMMdd);
        // System.out.println(num);

        // System.out.println(pin.charAt(7)); // 1이면 남자, 2면 여자

        // String a = "a:b:c:d";
        // String b = a.replaceAll(":","#");
        // System.out.println(b);
        
        // ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        // myList.sort(Comparator.reverseOrder());

        // 리스트를 문자열로 만들기
        // ArrayList<String> myList = new ArrayList<>(Arrays.asList("life","is","too","short"));

        // String result = String.join("",myList);
        // System.out.println(result); // "Life is too short" 출력
        
        HashMap<String, Integer> grade = new HashMap<>();
        grade.put("a",90);
        grade.put("b",80);
        grade.put("c",70);

        int result =  grade.remove("b");
        System.out.println(result);
        System.out.println(grade);
        
        


        
        

    }
    
}
 