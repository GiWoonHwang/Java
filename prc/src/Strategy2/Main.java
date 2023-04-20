package Strategy2;

import Strategy.*;

public class Main {
    public static void main(String[] args) {
        Wow wow = new Wow();

        Alliance hunter = new Alliance();
        hunter.setName("tom");
        hunter.setJob("hunter");
        hunter.setLevel(40);


        Horde soldier = new Horde();
        soldier.setName("dustin");
        soldier.setJob("hunter");
        soldier.setLevel(60);


        wow.setRide(soldier);
        wow.riding();



    }
}
