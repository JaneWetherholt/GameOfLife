import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class GameBoardTest {
    private int[][] boardData;

    @BeforeEach
    public void setUp() {
        // Create a sample board data for testing
        boardData = new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
    }

    @Test
    public void testGetRowCount() {
        GameBoard gameBoard = new GameBoard(boardData);
        Assertions.assertEquals(3, gameBoard.getRowCount());
    }

    @Test
    public void testGetColumnCount() {
        GameBoard gameBoard = new GameBoard(boardData);
        Assertions.assertEquals(3, gameBoard.getColumnCount());
    }

    @Test
    public void testGetValueAt() {
        GameBoard gameBoard = new GameBoard(boardData);
        Assertions.assertEquals(1, gameBoard.getValueAt(0, 0));
        Assertions.assertEquals(0, gameBoard.getValueAt(0, 1));
    }

    @Test
    public void testGetBoardData() {
        GameBoard gameBoard = new GameBoard(boardData);
        Assertions.assertTrue(Arrays.deepEquals(boardData, gameBoard.getBoardData()));
    }

    @Test
    public void testEquals() {
        GameBoard gameBoard1 = new GameBoard(boardData);
        GameBoard gameBoard2 = new GameBoard(boardData);
        GameBoard gameBoard3 = new GameBoard(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 0}});

        Assertions.assertTrue(gameBoard1.equals(gameBoard2));
        Assertions.assertFalse(gameBoard1.equals(gameBoard3));
    }

    @Test
    public void testPrintBoard() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GameBoard gameBoard = new GameBoard(boardData);
        gameBoard.printBoard();

        String expectedOutput = "1 0 1 \r\n" +
                "0 1 0 \r\n" +
                "1 0 1 \r\n";
        Assertions.assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
}