package chapter03.builder;

import chapter03.intro.domain.Maze;

public class CountingMazeBuilder implements MazeBuilder {

    private int rooms;
    private int doors;

    public CountingMazeBuilder() {
        this.rooms = 0;
        this.doors = 0;
    }

    @Override
    public void buildMaze() {

    }

    @Override
    public void buildRoom(int room) {
        rooms++;
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo) {
        doors++;
    }

    @Override
    public Maze getMaze() {
        return null;
    }

    public int getRooms() {
        return rooms;
    }

    public int getDoors() {
        return doors;
    }
}
