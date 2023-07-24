import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameBoardEvaluatorTest {

    @Test
    public void testBoardEvaluation() {
        int[][] inputBoardData =
            {
                {1,0,1,0},
                {1,1,0,0},
                {0,0,1,1},
                {0,1,0,1}
            };
        GameBoard inputBoard = new GameBoard(inputBoardData);
        int[][] expectedBoardData =
            {
                {1,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {0,0,0,1}
            };
        GameBoard expectedBoard = new GameBoard(expectedBoardData);
        GameBoard gameBoardOutput = new GameBoardEvaluator().evaluateGameBoard(inputBoard);
        Assertions.assertTrue(gameBoardOutput.equals(expectedBoard));
    }

    @Test
    public void testInvalidGameBoard() {
        int[][] inputBoardData =
            {
                {4,7},
                {2,9},
            };
        GameBoard inputBoard = new GameBoard(inputBoardData);
        Assertions.assertThrows(
            IllegalStateException.class,
            () -> new GameBoardEvaluator().evaluateGameBoard(inputBoard)
        );
    }

    @Test
    public void deadBoardStaysDead() {
        int[][] inputBoardData =
            {
                {0,0},
                {0,0}
            };
        GameBoard inputBoard = new GameBoard(inputBoardData);
        GameBoard gameBoardOutput = new GameBoardEvaluator().evaluateGameBoard(inputBoard);
        Assertions.assertTrue(gameBoardOutput.equals(inputBoard));
    }
}
