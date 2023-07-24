import java.util.Scanner;

public class GameConfigurator {
    private Scanner scanner;

    public GameConfigurator() {
        this.scanner = new Scanner(System.in);
    }

    public GameBoard createGameBoard() {
        System.out.println("To create a game board, please input the number of rows you'd like your game board to have.");
        int rowAmount = determineValidRowColumnInput(scanner.nextInt());
        System.out.println("Next, please input the number of columns you'd like to have on your game board.");
        int columnAmount = determineValidRowColumnInput(scanner.nextInt());

        int[][] boardData = populateGameBoard(rowAmount, columnAmount);
        return new GameBoard(boardData);
    }

    private int determineValidRowColumnInput(int userInput) {
        while(userInput < 2) {
            System.out.println("Whoops! Your input must be equal to or higher than 2 to play!");
            userInput = scanner.nextInt();
        }
        int updatedInput = userInput;

        return updatedInput;
    }

    private int[][] populateGameBoard(int rowAmount, int columnAmount) {
        int[][] gameBoard = new int[rowAmount][columnAmount];
        for (int i = 0; i < rowAmount; i++) {
            int rowInputCount = i + 1;
            System.out.println("(" + rowInputCount + "/" + rowAmount + ") Please enter a series of " + columnAmount + " live cells and dead cells");
            String rowValues = scanner.next();
            char[] splitRowValues = rowValues.toCharArray();
            for (int j = 0; j < columnAmount; j++) {
                int cellValue = Character.getNumericValue(splitRowValues[j]);
                if (!isValidInput(cellValue)) {
                    System.out.println("Invalid input. Please enter only " + CellState.LIVE.value + "s and " + CellState.DEAD.value + "s.");
                    String retryRow = scanner.next();
                    splitRowValues = retryRow.toCharArray();
                    j--;
                } else {
                    gameBoard[i][j] = cellValue;
                }
            }
        }

        return gameBoard;
    }

    private boolean isValidInput(int cellValue) {
        return (cellValue == CellState.DEAD.value || cellValue == CellState.LIVE.value);
    }
}
