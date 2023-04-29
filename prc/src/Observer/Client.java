package Observer;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String arg[]){
        Admin admin = new Admin();
        Room1 room1 = new Room1("1번방");
        Room2 room2 = new Room2("2번방");

        admin.attach(room1);
        admin.attach(room2);

        String msg = "공지사항입니다.";
        admin.notifyObservers(msg);

        admin.detach(room1);
        msg = "두 번째 공지사항입니다.";
        admin.notifyObservers(msg);
    }
}
