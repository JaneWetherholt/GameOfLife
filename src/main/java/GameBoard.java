import java.util.Arrays;

public class GameBoard {
    private int[][] boardData;

    public GameBoard(int[][] boardData) {
        this.boardData = boardData;
    }

    public int getRowCount() {
        return boardData.length;
    }

    public int getColumnCount() {
        return boardData[0].length;
    }

    public int getValueAt(int row, int column) {
        return boardData[row][column];
    }

    public int[][] getBoardData() {
        return boardData;
    }

    public boolean equals(GameBoard board) {
        return Arrays.deepEquals(this.boardData, board.getBoardData());
    }

    public void printBoard() {
        for (int[] rows : boardData) {
            for (int value : rows) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
