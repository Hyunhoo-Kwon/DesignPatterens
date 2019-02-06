package chapter03.abstractfactory;

import chapter03.intro.domain.*;

public class EnchantedMazeFactory implements MazeFactory {

    public EnchantedMazeFactory() {
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
        return new EnchantedRoom(n);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new DoorNeedingSpell(r1, r2);
    }
}
