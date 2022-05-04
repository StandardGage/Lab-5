package Lab5;

/**
 * Defines the action a player can take when moving a piece across the board (from one square to another).
 * Derived from action class; "From" piece means piece that is doing the action.
 *
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class ActionMove extends Action{

    public ActionMove(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     * Calls from piece's speak method, removes it from the 'from' square
     * and places it on the 'to' square, then changes turn.
     */
    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
        fromPiece.speak();
        game.getBoardSquares()[fromRow][fromColumn].removePiece();
        game.getBoardSquares()[toRow][toColumn].setPiece(fromPiece);
        game.changeTurn();
    }
}
