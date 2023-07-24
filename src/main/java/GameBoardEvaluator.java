public class GameBoardEvaluator {
    public GameBoard evaluateGameBoard(GameBoard gameBoard) throws IllegalStateException {
        int rowCount = gameBoard.getRowCount();
        int columnCount = gameBoard.getColumnCount();
        int[][] nextState = new int[rowCount][columnCount];

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                int currentCellValue = gameBoard.getValueAt(r, c);
                if (currentCellValue == CellState.LIVE.value || currentCellValue == CellState.DEAD.value) {
                    int neighborCount = countNeighbors(r, c, gameBoard);
                    int newCellValue = calculateNewCellValue(neighborCount, gameBoard.getValueAt(r, c));

                    nextState[r][c] = newCellValue;
                } else {
                    throw new IllegalStateException("Whoops! That isn't a valid cell value. Please try again!");
                }
            }
        }

        return new GameBoard(nextState);
    }

    private int countNeighbors(int row, int column, GameBoard gameBoard) {
        int count = 0;
        int rowStartPosition = Math.max(row - 1, 0);
        int columnStartPosition = Math.max(column - 1, 0);
        int rowCount = gameBoard.getRowCount();
        int columnCount = gameBoard.getColumnCount();

        for (int i = rowStartPosition; i <= row + 1 && i < rowCount; i++) {
            for (int j = columnStartPosition; j <= column + 1 && j < columnCount; j++) {
                if (!(i == row && j == column) && gameBoard.getValueAt(i, j) == CellState.LIVE.value) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int calculateNewCellValue(int count, int cellValue) {
        if (cellValue == CellState.LIVE.value && (count == 2 || count == 3)) {
            return CellState.LIVE.value;
        } else if (count == 3) {
            return CellState.LIVE.value;
        }

        return CellState.DEAD.value;
    }
}

