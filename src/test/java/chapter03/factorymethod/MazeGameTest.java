package chapter03.factorymethod;

import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class MazeGameTest {

    private MazeGame mazeGame;

    @Test
    public void createDefaultMaze() throws Exception {
        mazeGame = new DefaultMazeGame();
        Maze maze = mazeGame.createMaze();

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(Room.class));
    }

    @Test
    public void createEnchantedMaze() throws Exception {
        mazeGame = new EnchantedMazeGame();
        Maze maze = mazeGame.createMaze();

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(Room.class));
    }

    @Test
    public void createBombedMaze() throws Exception {
        mazeGame = new BombedMazeGame();
        Maze maze = mazeGame.createMaze();

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(Room.class));
    }

}
