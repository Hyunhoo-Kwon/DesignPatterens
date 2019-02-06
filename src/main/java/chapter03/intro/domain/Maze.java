package chapter03.intro.domain;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private List<Room> rooms = new ArrayList<>();

    public Maze() {
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room roomNo(int roomNumber) {
        for(Room room : rooms) {
            if(room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
