package Lab5;

/**
 * Represents on a space on a GameBoard. Can be empty or contain a piece.
 * This class can add or remove pieces from the squares. Squares have colors as well.
 *
 * @author Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class BoardSquare {
    private boolean isEmpty = true;
    private Piece piece;
    private String squareColor;
    private boolean hiddenSquare = false;

    public BoardSquare(String squareColor) {
        this.squareColor = squareColor;
    }

    public Piece getPiece() {
        if(isEmpty()) {
            return null;
        }
        return this.piece;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public String getSquareColor() {
        return this.squareColor;
    }

    public boolean isHiddenSquare() {
        return this.hiddenSquare;
    }


    public void setHiddenSquare(boolean hiddenSquare){this.hiddenSquare = hiddenSquare;}

    public void setPiece(Piece piece) {
        this.piece = piece;
        isEmpty = false;
    }

    /**
     * Removes piece from board square and makes it empty.
     * @return The piece that was previously on this Board Square.
     */
    public Piece removePiece() {
        Piece removed = this.piece;
        this.piece = null;
        this.isEmpty = true;
        return removed;
    }

    @Override
    public String toString() {
        return this.isEmpty ? "-------" : "-" + piece.toString() + "-";
    }
}
