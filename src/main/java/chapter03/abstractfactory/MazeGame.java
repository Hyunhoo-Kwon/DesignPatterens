package chapter03.abstractfactory;

import chapter03.intro.domain.Door;
import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import chapter03.intro.enums.Direction;

public class MazeGame {

    public Maze createMaze(MazeFactory factory) {
        Maze aMaze = factory.makeMaze();
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        Door aDoor = factory.makeDoor(r1, r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        r1.setSide(Direction.North, factory.makeWall());
        r1.setSide(Direction.East, aDoor);
        r1.setSide(Direction.South, factory.makeWall());
        r1.setSide(Direction.West, factory.makeWall());

        r2.setSide(Direction.North, factory.makeWall());
        r2.setSide(Direction.East, factory.makeWall());
        r2.setSide(Direction.South, factory.makeWall());
        r2.setSide(Direction.West, aDoor);

        return aMaze;
    }
}
