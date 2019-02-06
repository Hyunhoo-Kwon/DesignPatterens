package chapter03.abstractfactory;

import chapter03.intro.domain.Door;
import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import chapter03.intro.domain.Wall;

public class DefaultMazeFactory implements MazeFactory {

    public DefaultMazeFactory() {
    }

    @Override
    public Maze makeMaze() {
        return new Maze();
    }

    @Override
    public Wall makeWall() {
        return new Wall();
    }

    @Override
    public Room makeRoom(int n) {
        return new Room(n);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
