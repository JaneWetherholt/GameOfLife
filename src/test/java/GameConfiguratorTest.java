import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class GameConfiguratorTest {
    private GameConfigurator configurator;
    private ByteArrayOutputStream outputStream;
    private InputStream stdin;
    private String input;

    @BeforeEach
    public void setUp() {
        input = "3\n3\n101\n010\n101\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        configurator = new GameConfigurator();

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        // Restore original System.in after each test
        System.setIn(stdin);
    }

    @Test
    public void testCreateGameBoard() {
        GameBoard gameBoard = configurator.createGameBoard();
        Assertions.assertNotNull(gameBoard);
        Assertions.assertEquals(3, gameBoard.getRowCount());
        Assertions.assertEquals(3, gameBoard.getColumnCount());

        int[][] expectedBoardData = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        Assertions.assertTrue(Arrays.deepEquals(expectedBoardData, gameBoard.getBoardData()));
    }

    @Test
    public void testPrintBoardInputPrompt() {
        GameConfigurator configurator = new GameConfigurator();
        configurator.createGameBoard();

        String expectedOutput = "To create a game board, please input the number of rows you'd like your game board to have.\r\n" +
                "Next, please input the number of columns you'd like to have on your game board.\r\n" +
                "(1/3) Please enter a series of 3 live cells and dead cells\r\n" +
                "(2/3) Please enter a series of 3 live cells and dead cells\r\n" +
                "(3/3) Please enter a series of 3 live cells and dead cells\r\n";

        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testCreateGameBoardWithInvalidInput() {
        input = "3\n3\n101\n00a\n000\n011\n";
        stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        configurator = new GameConfigurator();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        configurator.createGameBoard();

        String expectedOutput = "To create a game board, please input the number of rows you'd like your game board to have.\r\n" +
                "Next, please input the number of columns you'd like to have on your game board.\r\n" +
                "(1/3) Please enter a series of 3 live cells and dead cells\r\n" +
                "(2/3) Please enter a series of 3 live cells and dead cells\r\n" +
                "Invalid input. Please enter only 1s and 0s.\r\n" +
                "(3/3) Please enter a series of 3 live cells and dead cells\r\n";
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
}
