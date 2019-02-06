package chapter03.builder;

import chapter03.intro.domain.Door;
import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import chapter03.intro.domain.Wall;
import chapter03.intro.enums.Direction;

public class StandardMazeBuilder implements MazeBuilder {

    private Maze currentMaze;

    public StandardMazeBuilder() {
    }

    @Override
    public void buildMaze() {
        this.currentMaze = new Maze();
    }

    @Override
    public void buildRoom(int n) {
        if(currentMaze.roomNo(n) == null) {
            Room room = new Room(n);
            currentMaze.addRoom(room);

            room.setSide(Direction.North, new Wall());
            room.setSide(Direction.South, new Wall());
            room.setSide(Direction.East, new Wall());
            room.setSide(Direction.West, new Wall());
        }
    }

    @Override
    public void buildDoor(int n1, int n2) {
        Room r1 = currentMaze.roomNo(n1);
        Room r2 = currentMaze.roomNo(n2);
        Door d = new Door(r1, r2);

        r1.setSide(commonWall(r1, r2), d);
        r2.setSide(commonWall(r2, r1), d);
    }

    @Override
    public Maze getMaze() {
        return currentMaze;
    }

    private Direction commonWall(Room r1, Room r2) {
        // ...
        return Direction.East;
    }

}
