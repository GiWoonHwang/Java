class Animal{
    String name; // 객체변수

    public void setName(String name){
        this.name = name;
    }

}
public class Sample {
    public static void main(String[] args){
        Animal cat = new Animal();
        cat.setName("boby");

        Animal dog = new Animal();
        dog.setName("happy");

        // 객체 변수는 공유하지 않는다
        System.out.println(cat.name);
        System.out.println(dog.name);





    }


}
