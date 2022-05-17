package Lab5;

//New Action Modification
public class ActionTeleport extends Action{
    public ActionTeleport(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     * Calls from Piece's speak method, generates a random (non-empty) board square,
     * and switches toPiece's spot with whatever piece is on that random board square.
     * Changes the turn.
     */
    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
        fromPiece.speak();
        Piece teleportedPiece1 = game.getBoardSquares()[toRow][toColumn].removePiece();

        //finds random non-empty square
        BoardSquare randomSquare = game.getBoardSquares()[(int) (Math.random() * game.getGameBoard().getNumRows())][(int) (Math.random()
                    * game.getGameBoard().getNumColumns())];
        while (randomSquare.isEmpty()) {
            randomSquare = game.getBoardSquares()[(int) (Math.random() * game.getGameBoard().getNumRows())][(int) (Math.random() * game.getGameBoard().getNumColumns())];
        }

        //swaps pieces
        Piece teleportedPiece2 = randomSquare.removePiece();
        game.getBoardSquares()[toRow][toColumn].setPiece(teleportedPiece2);
        randomSquare.setPiece(teleportedPiece1);

        game.changeTurn();
    }
}
