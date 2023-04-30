package Observer;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String arg[]) {
        Admin admin = new Admin();
        List<Room> rooms = new ArrayList<>();

//        rooms.add(new Room1("1번방"));
//        rooms.add(new Room2("2번방"));

        admin.setRoom(rooms);
        admin.talk("공지사항 입니다.");
    }
}
