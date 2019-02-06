package chapter03.builder;

import chapter03.intro.domain.Maze;

public class MazeGame {

    public Maze createMaze(MazeBuilder builder) {
        builder.buildMaze();

        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);

        return builder.getMaze();
    }

}
