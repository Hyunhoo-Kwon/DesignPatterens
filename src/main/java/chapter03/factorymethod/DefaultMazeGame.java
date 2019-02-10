package chapter03.factorymethod;

import chapter03.intro.domain.Door;
import chapter03.intro.domain.Room;
import chapter03.intro.domain.Wall;

public class DefaultMazeGame extends MazeGame {

    public DefaultMazeGame() {
    }

    @Override
    public Room makeRoom(int n) {
        return new Room(n);
    }

    @Override
    public Wall makeWall() {
        return new Wall();
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }

}
