package Lab5;

/**
 * This class represents an action the player can take where they create a copy
 * of their own piece on the From Square and put it on the To Square.
 *
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class ActionSpawn extends Action {

    public ActionSpawn(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     * Calls the from Piece's speak method and its spawn method, add Piece that was created
     * to the current team, and put that piece on the 'to' square. Then change the turn.
     *
     *If toSquare is the hidden piece, abducted timer is increased by 1.
     */
    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
        fromPiece.speak();
        Piece spawnPiece = fromPiece.spawn();
        game.getCurrentTeam().addPieceToTeam(spawnPiece);
        game.getBoardSquares()[toRow][toColumn].setPiece(spawnPiece);
        game.changeTurn();

        if(game.getBoardSquares()[toRow][toColumn].isHiddenSquare()){
            spawnPiece.setAbducted(spawnPiece.abductedTimer + 1);
        }
    }

}
