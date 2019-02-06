package chapter03.abstractfactory;

import chapter03.intro.domain.EnchantedRoom;
import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import chapter03.intro.domain.RoomWithABomb;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class MazeGameTest {

    private MazeGame mazeGame = new MazeGame();

    @Test
    public void createDefaultMaze() {
        MazeFactory factory = new DefaultMazeFactory();
        Maze maze = mazeGame.createMaze(factory);

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(Room.class));
    }

    @Test
    public void createEnchantedMaze() {
        MazeFactory factory = new EnchantedMazeFactory();
        Maze maze = mazeGame.createMaze(factory);

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(EnchantedRoom.class));
    }

    @Test
    public void createBombedMaze() {
        MazeFactory factory = new BombedMazeFactory();
        Maze maze = mazeGame.createMaze(factory);

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(RoomWithABomb.class));
    }

}
