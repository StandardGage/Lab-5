package Lab5;

public class BoardSquare {
    private boolean isEmpty = true;
    private Piece piece;
    private String squareColor;

    public BoardSquare(String squareColor) {
        this.squareColor = squareColor;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public String getSquareColor() {
        return squareColor;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        isEmpty = false;
    }

    public Piece removePiece() {
        Piece removed = piece;
        piece = null;
        isEmpty = true;
        return removed;
    }

    @Override
    public String toString() {
        return isEmpty ? "-------" : "-" + piece.toString() + "-";
    }
}
