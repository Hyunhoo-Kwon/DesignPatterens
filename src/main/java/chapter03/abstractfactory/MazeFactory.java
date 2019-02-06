package chapter03.abstractfactory;

import chapter03.intro.domain.Door;
import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import chapter03.intro.domain.Wall;

public interface MazeFactory {

    public Maze makeMaze();
    public Wall makeWall();
    public Room makeRoom(int n);
    public Door makeDoor(Room r1, Room r2);
}
