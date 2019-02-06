package chapter03.builder;

import chapter03.intro.domain.Maze;

public interface MazeBuilder {

    public void buildMaze();
    public void buildRoom(int room);
    public void buildDoor(int roomFrom, int roomTo);
    public Maze getMaze();

}
