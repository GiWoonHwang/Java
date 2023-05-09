class Updater {
    void update(Counter counter){ // 단순히 값을 받으면 객체 값을 변경할 수 없다
        counter.count ++;
    }
}

class Counter {
    int count = 0; // 객체변수
}



public class Sample {
    public static void main(String[] args){
        Counter myCounter = new Counter();
        System.out.println("before update:"+myCounter.count);

        Updater myUpdater = new Updater();
        myUpdater.update(myCounter); // 이렇게 메서드의 입력으로 객체를 전달받는 경우에는 메서드가 입력받은 객체를 그대로 사용하기 때문에 메서드가 객체의 속성값을 변경하면 메서드 수행 후에도 객체의 변경된 속성값이 유지된다.

        System.out.println("after update:"+myCounter.count);



    }


}
