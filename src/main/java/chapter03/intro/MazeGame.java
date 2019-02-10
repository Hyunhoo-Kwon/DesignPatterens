package chapter03.intro;

import chapter03.intro.domain.*;
import chapter03.intro.enums.Direction;

public class MazeGame {

    public Maze createMaze() {
        Maze aMaze = new Maze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door theDoor = new Door(r1, r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        r1.setSide(Direction.North, new Wall());
        r1.setSide(Direction.East, theDoor);
        r1.setSide(Direction.South, new Wall());
        r1.setSide(Direction.West, new Wall());

        r2.setSide(Direction.North, new Wall());
        r2.setSide(Direction.East, new Wall());
        r2.setSide(Direction.South, new Wall());
        r2.setSide(Direction.West, theDoor);

        return aMaze;
    }

    public Maze createEnchantedMaze() {
        Maze aMaze = new Maze();
        Room r1 = new EnchantedRoom(1);
        Room r2 = new EnchantedRoom(2);
        Door theDoor = new DoorNeedingSpell(r1, r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        // ...

        return aMaze;
    }

    public Maze createBombedMaze() {
        Maze aMaze = new Maze();
        Room r1 = new RoomWithABomb(1);
        Room r2 = new RoomWithABomb(2);
        Door theDoor = new Door(r1, r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        // ...

        return aMaze;
    }

}
