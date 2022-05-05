package Lab5;

/**
 * This class represents an action the player can take where they recruit an opponent’s piece on
 * the to square with their own piece on the from square.
 *
 *  @authors Faith Lovell and Gage Schuster
 *  @version 1.0
 */
public class ActionRecruit extends Action {

    public ActionRecruit(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     * Calls the Piece's speak method, remove the recruited piece from opponent's team,
     * and add the Piece that was recruited to the current team. Change the turn.
     */
    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
        fromPiece.speak();
        game.getOpponentTeam().removePieceFromTeam(fromPiece);
        game.getCurrentTeam().addPieceToTeam(fromPiece);
        game.changeTurn();
    }

}
