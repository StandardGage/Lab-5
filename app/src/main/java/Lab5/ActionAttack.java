package Lab5;

/**
 * This class will represent an action the player can take where they attack another piece on the to
 * square with their own piece on the from square.
 *
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class ActionAttack extends Action {

    public ActionAttack(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     * For attacking opponent pieces: call the speak method, move attacked piece to one side of board,
     * move the from square Piece to the to square. Changes the turn.
     *
     * For attacking same team pieces: call from Piece speak method, remove attacked piece from board &
     * opponents team, create a new Evil Minion Piece and add it to the current team, then place it
     * on the board where the Minion was, change the turn.
     *
     * If toSquare is the hidden piece, abducted timer is increased by 1.
     */
    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].removePiece();
        fromPiece.speak();
        Piece attackedPiece = game.getBoardSquares()[toRow][toColumn].removePiece();
        game.getOpponentTeam().removePieceFromTeam(attackedPiece);
        game.getBoardSquares()[toRow][toColumn].setPiece(fromPiece);
        game.changeTurn();
        if(game.getBoardSquares()[toRow][toColumn].isHiddenSquare()){
            fromPiece.setAbducted(fromPiece.abductedTimer + 1);
        }

        if (fromPiece instanceof PieceEvilMinion) {
            if (attackedPiece instanceof PieceMinion) {
                PieceEvilMinion eMinion = new PieceEvilMinion();
                game.getOpponentTeam().addPieceToTeam(eMinion);
                game.getBoardSquares()[fromRow][fromColumn].setPiece(eMinion);
            }
        }

    }

}
