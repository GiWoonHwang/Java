package Strategy;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Functionable galaxyPhone = new Samsung();
        Functionable iPhone = new Apple();
        Functionable optimus = new Lg();

        phone.setPhone(galaxyPhone);
        phone.phoneCall();
        phone.answerPhone();

        phone.setPhone(iPhone);
        phone.phoneCall();
        phone.answerPhone();

        phone.setPhone(optimus);
        phone.phoneCall();
        phone.answerPhone();
    }

}