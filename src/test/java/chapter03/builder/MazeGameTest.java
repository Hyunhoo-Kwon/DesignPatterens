package chapter03.builder;

import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class MazeGameTest {

    private MazeGame mazeGame = new MazeGame();

    @Test
    public void createStandardMaze() {
        MazeBuilder builder = new StandardMazeBuilder();
        Maze maze = mazeGame.createMaze(builder);

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(Room.class));
    }

    @Test
    public void createCountingMaze() {
        MazeBuilder builder = new CountingMazeBuilder();
        mazeGame.createMaze(builder);

        int rooms = ((CountingMazeBuilder) builder).getRooms();
        int doors = ((CountingMazeBuilder) builder).getDoors();

        System.out.println("the maze has " + rooms + " rooms and " + doors + " doors");
    }

}
