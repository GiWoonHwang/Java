
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
// public class Sample {
//     public static void main(String[] args) throws IOException {
//         FileOutputStream output = new FileOutputStream("C:/Users/PC/Desktop/out.txt");
//         for (int i =1; i<11; i++){
//             String data = i + "번 째 줄 입니다.\r\n";

//             // FileOutputStream에 값을 쓸 때는 byte배열로 써야 하므로 위와같이 String을 byte배열로 바꾸어 주는 getBytes() 메서드를 이용했다.
//             output.write(data.getBytes());
//         }
        
//         // 자바에서는 자동으로 닫아주지만, 직접 사용한 파일은 닫아주는게 좋다. 사용했던 파일을 닫지않고 다시 사용하려 하면 오류가 발생하기 때문
//         output.close();
//     }
// }

// 문자열 파일을 쓰는 좀 더 편리한 방법


// public class Sample {
//     public static void main(String[] args) throws IOException {
//         PrintWriter pw = new PrintWriter("C:/Users/PC/Desktop/out.txt");
//         for(int i=1; i<11; i++) {
//             String data = i+" 번째 줄입니다.";
//             pw.println(data);
//         }
//         pw.close();

//         // 내용 추가하기, true면 덮어쓰지 않고 이어서 쓴다
//         FileWriter fw2 = new FileWriter("c:/out.txt", true);  // 파일을 추가 모드로 연다.
//         for(int i=11; i<21; i++) {
//             String data = i+" 번째 줄입니다.\r\n";
//             fw2.write(data);
//         }
//         fw2.close();
//     }
// }

// // 파일을 라인단위로 읽어준다.
// public class Sample {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new FileReader("c:/out.txt"));
//         while(true) {
//             String line = br.readLine();
//             if (line==null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
//             System.out.println(line);
//         }
//         br.close();
//     }
// }
//

// public class Sample{
//     public static void main(String[] args) throws IOException{
//         InputStream in  = System.in;

        // int a;
        
        /*
        * "abc" 를 입력했지만 출력은 "a"에 해당되는 아스키 코드값만 출력되었다. 
        * 그 이유는 InputStream의 read 메서드는 1 byte만 읽기 때문이다. 즉, 사용자는 "abc"라는 총 3 byte의 데이터를 전달했지만 프로그램에서 1 byte만 읽은 경우라고 할 수 있다. 이렇게 사용자가 전달한 1 byte의 데이터 또는 3 byte의 데이터를 다른 말로 입력 스트림(Stream)이라고 한다. 스트림은 이어져 있는 데이터(byte)의 형태를 의미한다.
        * 
        */
        // a = in.read(); // 1byte(8bit)의 사용자 입력을 받아들인다
        // System.out.println(a);

        // int a;
        // int b;
        // int c;

        // a = in.read();
        // b = in.read();
        // c = in.read();

        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);

        // byte[] a = new byte[3];
        // in.read(a);

        // System.out.println(a[0]);
        // System.out.println(a[1]);
        // System.out.println(a[2]);
        
//     }
// }

// 입력받은 문자를 아스키 코드가 아님 그대로 출력하는 방법
// 그러나 항상 3byte만 읽도록 고정되어 있다.
// public class Sample{
//     public static void main(String[] args) throws IOException{
//         InputStream in = System.in;
//         InputStreamReader reader = new InputStreamReader(in);
//         BufferedReader br = new BufferedReader(reader);
//         String a = br.readLine();
//         char[] a = new char[3];
//         reader.read(a);

//         System.out.println(a); 
//     }
// }

// 콘솔 입력을 쉽게 처리할 수 있는 scanner
/*
    Scanner 객체의 next() 메서드는 단어 하나(Token)를 읽어들인다. Scanner 클래스에는 단어 뿐만 아니라 숫자, 문자열등 다양하게 읽어 들일 수 있는 여러 메서드들이 준비되어 있는데 몇가지만 알아보면 다음과 같은 것들이 있다.

    next - 단어
    nextLine - 라인
    nextInt - 정수
 * 
 */
// public class Sample{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.println(sc.next());
//     }
// }


// class Calculator {
//     int value;


//     /*
//      * Integer 자료형은 값을 대입하지 않을 경우 null이기 때문에 add 메서드에서 null에 값을 더하려고 하기 때문에 오류가 발생한다. 따라서 다음처럼 Calculator 클래스의 생성자를 만들고 초깃값을 설정해야 한다.
//      * 
//      */
//     Calculator(){
//         this.value = 0;
//     }

//     void add(int val){ // 덧셈
//         this.value += val;
//     }

//     int getValue(){
//        return this.value;
//     }

//     boolean isOdd(int num){
//         return num % 2 == 1;
//     }

//     int avg(int[] data){
//         int total = 0;
//         for(int num: data){
//             total += num;
//         }
//         return total / data.length;
//     }

//     int avg(ArrayList<Integer> data){
//         int total = 0;
//         for(int num: data){
//             total += num;
//         }
//         return total/data.size();
//     }
// }

// class UpgeadeCalculator extends Calculator{
//     void minus(int val){
//         this.value -= val;
//     }
// }

// class MaxLimitCalculator extends Calculator{
//     void add(int val){
//         this.value += val;
//         if(this.value > 100){
//             this.value = 100;
//         }
//     }
// }

// public class Sample{
//     public static void main(String[] args){
//         // MaxLimitCalculator cal = new MaxLimitCalculator();

//         // cal.add(50);
//         // cal.add(60);
//         // System.out.println(cal.getValue());


//         // Calculator cal = new Calculator();
//         // System.out.println(cal.isOdd(3));  // 3은 홀수이므로 true 출력
//         // System.out.println(cal.isOdd(4));  // 4는 짝수이므로 false 출력


//         /*
//          * 
//                     array	                                    arrayList
//         사이즈	    초기화시 고정	                             초기화시 사이즈를 표시하지 않음. 사이즈가 동적이다.
//         속도	    초기화 시 메모리에 할당되어 속도 빠름       	추가시 메모리를 재할당하여 속도가 느림
//         변경	    사이즈 변경 불가	                         추가,삭제 가능
//         다차원	    가능	                                     불가능
//         타입	    primitive type(int,byte, char etc), object	object elemnet만 가능
//         제네릭	    사용 불가능	                                 사용 가능(타입 안정성 보장)
//         길이	    length 변수	                                 size() 메서드
//         변수 추가	assignment 연산자 사용	                     add() 메소드 사용
//          * 
//          */
//         Calculator cal = new Calculator();
//         int[] data1 = {1,3,5,7,9};
//         int result1 = cal.avg(data1);
//         System.out.println(result1); 

//         ArrayList<Integer> data2 = new ArrayList<>(Arrays.asList(1,3,5,7,9));
//         int result2 = cal.avg(data2);
//         System.out.println(result2);  // 5 출력

//         }
// }



/*
 * 다음은 광물의 가치를 계산하는 MineralCalculator 클래스와 그 사용법이 담긴 코드이다. 광물 계산기는 금인 경우 100, 은인 경우 90, 구리의 경우는 80의 가치를 더하는 기능(add 메스드)이 있다. 
 * 하지만 이 광물 계산기는 광물이 추가될 때마다 add 메서드를 추가해야 한다는 단점이 있다. 광물이 추가되더라도 MineralCalculator 클래스를 변경할 필요가 없도록 코드를 수정하시오.
 * 
 */

// interface Mineral{
//     int getValue();
// }

// class Gold implements Mineral{
//     public int getValue(){
//         return 100;
//     }
// }


// class Silver implements Mineral{
//     public int getValue(){
//         return 90;
//     }
// }

// class Bronze implements Mineral {
//     public int getValue() {
//         return 80;
//     }
// }

// class MineralCalculator{
//     int value = 0;

//     public void add(Mineral mineral){
//         this.value += mineral.getValue();
//     }

//     public int getValue(){
//         return this.value;
//     }
// }

// public class Sample{
//         public static void main(String[] args) {
//             MineralCalculator cal = new MineralCalculator();
//             cal.add(new Gold());
//             cal.add(new Silver());
//             cal.add(new Bronze());
//             System.out.println(cal.getValue());  // 270 출력
//     }
// }











/*
 *  난 동물원의 사육사이다.
    육식동물이 들어오면 난 먹이를 던져준다.
    호랑이가 오면 사과를 던져준다.
    사자가 오면 바나나를 던져준다.
 * 
 */

//  abstract class Predator extends Animal{
//     abstract String getFood();
//  }

//  interface Predator {
//     String getFood();

//     default void printFood() {
//         System.out.printf("my food is %s\n", getFood());
//     }

//     int LEG_COUNT = 4;  // 인터페이스 상수

//     static int speed() {
//         return LEG_COUNT * 30;
//     }
// }

// interface Barkable {
//     void bark();
// }

// interface BarkablePredator extends Predator, Barkable {
// }

// class Animal {
//     String name;

//     void setName(String name) {
//         this.name = name;
//     }
// }

// class Tiger extends Animal implements Predator, Barkable {
//     public String getFood() {
//         return "apple";
//     }

//     public void bark() {
//         System.out.println("어흥");
//     }
// }

// class Lion extends Animal implements BarkablePredator {
//     public String getFood() {
//         return "banana";
//     }

//     public void bark() {
//         System.out.println("으르렁");
//     }
// }

// class ZooKeeper {
//     void feed(Predator predator) {
//         System.out.println("feed " + predator.getFood());
//     }
// }

// class Bouncer {
//     void barkAnimal(Barkable animal) {
//         animal.bark();
//     }
// }

// public class Sample {
//     public static void main(String[] args) {
//         Tiger tiger = new Tiger();
//         Lion lion = new Lion();

//         Bouncer bouncer = new Bouncer();
//         bouncer.barkAnimal(tiger);
//         bouncer.barkAnimal(lion);
//     }
// }


// class Animal{
//     String name;

//     void setName(String name){
//         this.name = name;
//     }
// }

// class Dog extends Animal{

//     void sleep(){
//         System.out.println(this.name + "슬립 메서드");
//     }
// }

// class HouseDog extends Dog{
//     // 객체변수를 무조건 생성하게 해주는 생성자
//     // 생성자의 규칙: 클래스명과 메서드명이 동일하다, 리턴타입을 정의하지 않는다(void도 사용하지 않는다)
//     HouseDog(String name) {
//         this.setName(name);
//     }

//     HouseDog(int type){

//         // 하나의 클래스에 여러개의 입력항목이 다른 생성자를 만들 수 있다.
//         if(type == 1){
//             this.setName("york");
//         }
//         else if(type == 2){
//             this.setName("bulldog");
//         }
//     }


//     void sleep(){
//         System.out.println(this.name + "슬립 메소드 오버라이딩");
//     }

//     void sleep(int hour) {
//         System.out.println(this.name + "메소드 오버로딩" + hour);
//     }
// }

// public class Sample{
//     public static void main(String[] args){
//         HouseDog houseDog = new HouseDog("happy");
//         houseDog.setName("happy");
//         houseDog.sleep();
//         houseDog.sleep(1);
        
//         HouseDog dog = new HouseDog("happy");
//         System.out.println(dog.name);

//         HouseDog happy = new HouseDog("happy");
//         HouseDog yorkshire = new HouseDog(1);

//     }
// }










// class Animal {
//     String name;

//     void setName(String name){
//         this.name = name;
//     }
// }

// class Dog extends Animal{
//     void sleep(){
//         System.out.println(this.name + "자식클래스에 메서드 추가");
//     }

// }

// class HouseDog extends  Dog{
//     /*
//      * HouseDog 클래스에 Dog 클래스와 동일한 형태(입출력이 동일)의 sleep 메서드를 구현하면 HouseDog 클래스의 sleep 메서드가 Dog 클래스의 sleep 메서드보다 더 높은 우선순위를 갖게 되어 HouseDog 클래스의 sleep 메서드가 호출되게 된다.

//         이렇게 부모클래스의 메서드를 자식클래스가 동일한 형태로 또다시 구현하는 행위를 메서드 오버라이딩(Method Overriding)이라고 한다. (메서드 덮어쓰기)
//      * 
//      */
//     void sleep(){
//         System.out.println(this.name + "zzz in house");
//     }
//     // 이렇듯 입력항목이 다른 경우 동일한 이름의 메서드를 만들 수 있는데 이를 메서드 오버로딩(method overloading)이라고 부른다.
//     void sleep(int hour){
//         System.out.println(this.name+" zzz in house for " + hour + " hours");
//     }

// }

// public class Sample{
//     public static void main(String[] args){
//         // Dog dog   = new Dog();
//         // // Animal dog = new Dog(); // Animal 자료형으로 선언하면 sleep 메서드 못씀 sleep는 자식클래스에만 존재하니까
//         // Dog dog = new Animal();  // Animal is a Dog (X)
//         // dog.setName("poppy");
//         // System.out.println(dog.name);
//         // dog.sleep();
//         HouseDog houseDog = new HouseDog();
//         houseDog.setName("상속에 상속입니다.");
//         houseDog.sleep();
//         houseDog.sleep(3);  // happy zzz in house for 3 hours 출력
       
//     }
// }



/*
 * Object 클래스
자바에서 만드는 모든 클래스는 Object 클래스를 상속받는다. 사실 우리가 만든 Animal 클래스는 다음과 기능적으로 완전히 동일하다. 
하지만 굳이 아래 코드처럼 Object 클래스를 상속하도록 코딩하지 않아도 자바에서 만들어지는 모든 클래스는 Object 클래스를 자동으로 상속받게끔 되어 있다.

class Animal extends Object {
    String name;

    void setName(String name) {
        this.name = name;
    }
}
따라서 자바에서 만드는 모든 객체는 Object 자료형으로 사용할 수 있다. 즉, 다음과 같이 코딩하는 것이 가능하다.

Object animal = new Animal();  // Animal is a Object
Object dog = new Dog();  // Dog is a Object
 */





// class Calculator {
//     static int result = 0;
//     int add(int num){
//         result += num;
//         return result;
//     }
//     int sub(int num){
//         result -= num;
//         return result;
//     }
// }

// class Animal{
//     String name;

//     public void setName(String name){
//         this.name = name;
//     }

// }

// class Updater {
//     void update(Counter counter){
//         counter.count++;
//     }
// }

// class Counter{
//     int count = 0; // 객체 변수
// }



// public class Sample {
//     public static void main(String[] args){
//         Counter myCounter = new Counter();
//         System.out.println("before update" + myCounter.count);
        
//         Updater myUpdater = new Updater();
//         myUpdater.update(myCounter);
//         System.out.println("after update:"+myCounter.count);


//     }

    // int a;
    // void varTest() {
    //     this.a ++;
    // }
    // public static void main(String[] args) {
    //     // Sample sample = new Sample();
    //     // sample.a = 1;

    //     // sample.varTest();
    //     // System.out.println(sample.a);
    // }

    // void sayNick(String nick) {
    //     if ("fool".equals(nick)) { // 전달받는 인수가 fool과 동일하다면
    //         return; // 바로 리턴
    //     }
    //     System.out.println("나의 별명은 "+nick+" 입니다.");
    // }
    
    // Enum은 서로 관련이 있는 여러 개의 상수 집합을 정의할 때 사용하는 자료형이다.
    // 매직넘버(1과 같은 숫자 상수값)를 사용할 때보다 코드가 명확해 진다.
    // 잘못된 값을 사용함으로 인해 발생할수 있는 위험성이 사라진다.
    // enum CoffeeType{
    //     AMERICANO,
    //     ICE_AMERICANO,
    //     CAFE_LATTE
    // };

    // enum CoffeeType {
    //     AMERICANO,
    //     ICE_AMERICANO,
    //     CAFE_LATTE
    // };


    // static void printCoffeePrice(CoffeeType type){
    //     HashMap<CoffeeType, Integer> priceMap = new HashMap<>();
    //     priceMap.put(CoffeeType.AMERICANO, 3000);  // 1: 아메리카노
    //     priceMap.put(CoffeeType.ICE_AMERICANO, 4000);  // 2: 아이스 아메리카노
    //     priceMap.put(CoffeeType.CAFE_LATTE, 5000);  // 3: 카페라떼
    //     int price = priceMap.get(type);
    //     System.out.println(String.format("가격은 %d원 입니다", price));
    // }
    // public static  void main(String[] args){
        /*
         * return 문만 단독으로 사용하여 메서드를 빠져나가는 이 방법은 리턴 자료형이 void인 메서드에만 해당된다.
         * 리턴자료형이 명시되어 있는 메서드에서 return 문만 작성하면 컴파일 오류가 발생한다.
         * 
         */
        // Sample sample = new Sample();
        // sample.sayNick("dd");
        // sample.sayNick("fool");
        



        // Calculator cal1 = new Calculator();  // 계산기1 객체를 생성한다.
        // Calculator cal2 = new Calculator();  // 계산기2 객체를 생성한다.

        // System.out.println(cal1.add(3));
        // System.out.println(cal1.add(4));

        // System.out.println(cal2.add(3));
        // System.out.println(cal2.add(7));

        // Animal cat = new Animal();
        // Animal dog = new Animal();

        // // System.out.println(cat.setName("body"));
        // dog.setName("happy");
        
        // printCoffeePrice(CoffeeType.AMERICANO); 


        // ArrayList<String> pocket = new ArrayList<String>();
        // pocket.add("paper");
        // pocket.add("handphone");
        // pocket.add("money");

        // if(pocket.contains("money")){
        //     System.out.println("택시를 타고 가라");
        // }
        // else{
        //     System.out.println("걸어가라");
        // }


        // int money = 2000;
        // if(money >= 3000){
        //     System.out.println("택시를 타고 가라");
        // }
        // else{
        //     System.out.println("걸어가라");
        // }

        // int month = 8;
        // String monthString = "";
        // switch (month){
        //     case 1: monthString = "1월";
        //         break;
        //     case 2: monthString = "2월";
        //         break;
        //     default: monthString = "없음";

        // }
        // System.out.println(monthString);

        // int tree_hit = 0;
        // while(tree_hit < 10){
        //     tree_hit ++;
        //     System.out.println("나무를 " + tree_hit + "번 찍었습니다");
        //     if(tree_hit == 10){
        //         System.out.println("나무가 넘어갑니다.");
        //     }
        // }
        
        // int coffee = 10;
        // int money = 300;

        // while(money > 0){
        //     System.out.println("돈을 받았으니 커피를 준다");
        //     coffee --;
        //     System.out.println("남은 커피의 양은 " + coffee + "입니다");
        //     if(coffee == 0){
        //         System.out.println("커피가 다 떨어졌습니다. 판매를 중지합니다");
        //         break;
        //     }
        // }
        
        // 홀수만 출력한다.
        // int a = 0;

        // while(a< 10){
        //     a++;
        //     if(a % 2 == 0){
        //         continue; // 짝수인 경우 조건문으로 돌아간다.
        //     }
        //     System.out.println(a);  // 홀수만 출력된다.
        // }
        // String[] numbers = {"one","two","three"};
        // for(int i =0; i<numbers.length; i++){
        //     System.out.println(numbers[i]);
        // }

        // int[] marks = {90,25,67,45,80};
        // for(int i =0; i<marks.length; i++){
        //     if(marks[i] >= 60){
        //         System.out.println((i+1)+ "번 학생은 합격입니다.");
        //     }
        //     else{
        //         System.out.println((i+1)+ "번 학생은 불합격입니다.");
        //     }
        // }

        






        // System.out.println(CoffeeType.AMERICANO);
        // System.out.println(CoffeeType.ICE_AMERICANO);
        // System.out.println(CoffeeType.CAFE_LATTE);

        // for(CoffeeType type: CoffeeType.values()){
        //     System.out.println(type);
        // }
        
        // int[] marks = {90, 25, 67, 45, 80};
        // for (int i =0; i < marks.length; i++){
        //     if(marks[i]<60){
        //         continue;
        //     }
        //     else{
        //         System.out.println((i+1)+"번 학생 축하합니다. 합격입니다.");
        //     }
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
        
        // HashMap<String, Integer> grade = new HashMap<>();
        // grade.put("a",90);
        // grade.put("b",80);
        // grade.put("c",70);

        // int result =  grade.remove("b");
        // System.out.println(result);
        // System.out.println(grade);
        
        
        // ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,1,2,2,3,4,4,5,5));
        // HashSet<Integer> temp = new HashSet<>(numbers); // 집합은 중복과 순서가 존재하지 않는다.
        // ArrayList<Integer> result  = new ArrayList<>(temp);
        
        // for each 기존 for문보다 조금 더 직관적이다.

        // String[] numbers = {"one","two","three"};
        // for(String number: numbers){
        //     System.out.println(number);
        // }

        // int result = 0;
        // int i = 1;
        // while(i <= 1000){
        //     if(i % 3 == 0){
        //         result += i;
        //     }
        //     i += 1;
        // }
        // System.out.println(result);  // 166833 출력
        
        // 별 표시하기
        // int i = 0;
        // while(true){
        //     i += 1;
        //     if(i >5){
        //         break;
        //     }
        //     for(int j = 0; j < i; j++){
        //         System.out.print('*');
        //     }
        //     System.out.println("");
        // }

        // int i = 0;
        // while(true){
        //     i += 1;
        //     if(i>5){
        //         break;
        //     }
        //     for(int j = 0; j <i; j ++){
        //         System.out.print('*');
        //     }
        //     System.out.println("");
        // }

        // int[] marks = {70, 60, 55, 75, 95, 90, 80, 80, 85, 100};
        // int total = 0;
        // for (int mark: marks) {  // for each 문
        //     total += mark;  // A학급의 점수를 모두 더한다.
        // }
        // float average = (float) total / marks.length;  // 평균을 구하기 위해 총 점수를 총 학생수로 나눈다.
        // System.out.println(average);  // 평균 79.0이 출력된다.
        

        

        
        
        

    // }  
    
// }
 