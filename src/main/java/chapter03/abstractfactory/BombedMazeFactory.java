package chapter03.abstractfactory;

import chapter03.intro.domain.*;

public class BombedMazeFactory implements MazeFactory {

    public BombedMazeFactory() {
    }

    @Override
    public Maze makeMaze() {
        return new Maze();
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }

    @Override
    public Room makeRoom(int n) {
        return new RoomWithABomb(n);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
