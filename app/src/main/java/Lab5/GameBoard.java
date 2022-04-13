package Lab5;

/**
 * Creates a GameBoard object that sets rows, columns, and board square
 * objects for every space on the board. Can determine if a space is on
 * the board, and find empty spaces.
 *
 * @author Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        this.squares = new BoardSquare[rows][columns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return this.numRows;
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public BoardSquare[][] getSquares() {
        return this.squares;
    }

    /**
     * Determines if a space is in the bounds of the GameBoard
     * 
     * @param row    int representing the space's row
     * @param column int representing the space's column
     * @return boolean true if it is in bounds, false if it isn't
     */
    public boolean inBounds(int row, int column) {
        boolean bounds = false;
        if (row >= 0 && column >= 0 && column < getNumColumns() && row < getNumRows()) {
            bounds = true;
        }
        return bounds;
    }

    /**
     * Creates a board with alternating white and blue empty BoardSquare spaces.
     */
    private void setUpEmptyBoard() {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                if ((i - j) % 2 == 0) {
                    this.squares[i][j] = new BoardSquare("blue");
                } else {
                    this.squares[i][j] = new BoardSquare("white");
                }
            }
        }
    }

    /**
     * Generates random row and column indexes and checks to see if that space on
     * the Board is empty.
     *
     * @return the first randomly generated BoardSquare space that is empty.
     */
    public BoardSquare findRandomEmptySpace() {
        BoardSquare randomSquare = this.squares[(int) (Math.random() * this.numRows)][(int) (Math.random()
                * this.numColumns)];
        while (!randomSquare.isEmpty()) {
            randomSquare = this.squares[(int) (Math.random() * this.numRows)][(int) (Math.random() * this.numColumns)];
        }
        return randomSquare;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for (int col = 0; col < squares[0].length; col++) {
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for (int row = 0; row < squares.length; row++) {
            boardString.append("Row : " + row + "   ");
            for (int col = 0; col < squares[row].length; col++) {
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
