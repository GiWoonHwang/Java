package Observer;
/*
해당 코드를 실행하면 admin객체가 setRoom메소드를 통해 입장할 방을 선택하고 talk메소드를 통해 Room 객체 내부의 receive메소드가 실행되어 "안녕하세요"를 출력할 것이다.


* */

import java.util.List;

public class Admin extends Subject{
    private List <Room> room;

    public void setRoom(List <Room> room){
        this.room = room;
    }

    public void talk(String msg){
        for(Room numRoom: room){
            numRoom.receive(msg);
        }
    }

}
