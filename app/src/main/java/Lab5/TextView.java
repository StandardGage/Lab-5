package Lab5;

import java.util.Scanner;

/**
 * Text-based interface for users to play the game.
 *
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class TextView {
    int fromRow;
    int fromColumn;
    int toRow;
    int toColumn;
    char action;

    public int getFromRow() {
        return fromRow;
    }

    public int getFromColumn() {
        return fromColumn;
    }

    public int getToRow() {
        return toRow;
    }

    public int getToColumn() {
        return toColumn;
    }

    public char getAction() {
        return action;
    }

    /**
     * Asks user for input until they input an integer
     * between the specified min and max
     * 
     * @param min
     * @param max
     * @param scr Scanner for user input
     * @return integer inputted by user that is between min and max
     */
    public static int getValidInt(int min, int max, Scanner scr) {
        int input = min - 1;
        while (input <= min || input >= max) {
            System.out.print("Please enter an integer between " + min + " and " + max + ": ");
            try {
                input = scr.nextInt();
            } catch (Exception e) {
                scr.nextLine();
            }
            System.out.println();
        }
        return input;
    }

    /**
     * Takes user input until they enter 'A','M','R',or 'S'
     * -not case sensitive
     * 
     * @param scr Scanner for user input
     * @return input once user inputs 'A','M','R', or 'S'
     */
    public static char getUsersNextActionType(Scanner scr) {
        char input = 'A';
        boolean loop = true;
        while (loop) {
            input = scr.next().toUpperCase().charAt(0);
            switch (input) {
                case 'A':
                case 'M':
                case 'R':
                case 'S':
                case 'T':
                    loop = false;
                    break;

                default:
                    break;
            }
        }
        return input;

    }

    /**
     * Gets action type, and asks the player to enter from square they are selecting to assign it,
     * and ask them to enter the to square indexes and assign them.
     * @param game current game
     */
    public void getNextPlayersAction(GameS22 game) {
        Scanner scr = new Scanner(System.in);

        System.out.println("Enter Action:");
        action = getUsersNextActionType(scr);
        int rows = game.getGameBoard().getNumRows();
        int cols = game.getGameBoard().getNumColumns();
        do {
            System.out.println("Enter the row and column of the piece to use.");
            fromRow = getValidInt(-1, rows, scr);
            fromColumn = getValidInt(-1, cols, scr);
        } while (game.getBoardSquares()[fromRow][fromColumn].getPiece() == null);
        System.out.println("Enter the row and column of the square to perform action");
        toRow = getValidInt(-1, rows, scr);
        toColumn = getValidInt(-1, cols, scr);
    }

    /**
     * Prints the game object
     * @param game current game
     */
    public void updateView(Game game) {
        System.out.println(game);
    }

    /**
     * Displays when the game is over and which team won (or if there was no winner)
     * @param game current game
     */
    public void printEndOfGameMessage(Game game) {
        if (game.getWinner() != null) {
            System.out.println(game.getWinner() + " won the game");
        } else {
            System.out.println("The game is over, nobody won.");
        }
    }
}
