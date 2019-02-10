package chapter03.factorymethod;

import chapter03.intro.domain.Door;
import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import chapter03.intro.domain.Wall;
import chapter03.intro.enums.Direction;

public abstract class MazeGame {

    public Maze createMaze() {
        Maze aMaze = makeMaze();

        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);
        Door theDoor = makeDoor(r1, r2);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);

        r1.setSide(Direction.North, makeWall());
        r1.setSide(Direction.East, theDoor);
        r1.setSide(Direction.South, makeWall());
        r1.setSide(Direction.West, makeWall());

        r2.setSide(Direction.North, makeWall());
        r2.setSide(Direction.East, makeWall());
        r2.setSide(Direction.South, makeWall());
        r2.setSide(Direction.West, theDoor);

        return aMaze;

    }

    public Maze makeMaze() {
        return new Maze();
    }

    public abstract Room makeRoom(int n);

    public abstract Wall makeWall();

    public abstract Door makeDoor(Room r1, Room r2);

}
