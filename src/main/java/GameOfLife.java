import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) {
//        create print into method and move the following six lines to that method
        System.out.println("Welcome to Game of Life!");
        System.out.println("Each cell in your game board represents an entity, either living or dead.");
        System.out.println("A " + CellState.DEAD.value + " value means a cell is dead.");
        System.out.println("A " + CellState.LIVE.value + " value means a cell is alive.");
        System.out.println("Each cell will live or die based on how many cell around it are living or dead.");

        GameConfigurator configurator = new GameConfigurator();
        GameBoard gameBoard = configurator.createGameBoard();
        System.out.println("Here is the board you've created!");
        gameBoard.printBoard();

        System.out.println("Now the board you've made will be evaluated!");
        GameBoardEvaluator evaluator = new GameBoardEvaluator();
        GameBoard newBoard = evaluator.evaluateGameBoard(gameBoard);
        System.out.println("Here is your new board!");
        newBoard.printBoard();
    }
}
