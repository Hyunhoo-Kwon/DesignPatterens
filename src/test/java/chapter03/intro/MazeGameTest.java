package chapter03.intro;

import chapter03.intro.domain.Maze;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class MazeGameTest {

    private MazeGame mazeGame = new MazeGame();

    @Test
    public void createMaze1() throws Exception {
        Maze maze = mazeGame.createMaze1();

        assertThat(maze, instanceOf(Maze.class));
    }

    @Test
    public void createMaze2() throws Exception {
        Maze maze = mazeGame.createMaze2();

        assertThat(maze, instanceOf(Maze.class));
    }

}