package chapter03.intro;

import chapter03.intro.domain.EnchantedRoom;
import chapter03.intro.domain.Maze;
import chapter03.intro.domain.Room;
import chapter03.intro.domain.RoomWithABomb;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class MazeGameTest {

    private MazeGame mazeGame = new MazeGame();

    @Test
    public void createMaze() throws Exception {
        Maze maze = mazeGame.createMaze();

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(Room.class));
    }

    @Test
    public void createEnchantedMaze() {
        Maze maze = mazeGame.createEnchantedMaze();

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(EnchantedRoom.class));
    }

    @Test
    public void createBombedMaze() {
        Maze maze = mazeGame.createBombedMaze();

        assertThat(maze, instanceOf(Maze.class));
        assertThat(maze.roomNo(1), instanceOf(RoomWithABomb.class));
    }

}