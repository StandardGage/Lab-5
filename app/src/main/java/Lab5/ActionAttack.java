package Lab5;

public class ActionAttack extends Action {

    public ActionAttack(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].removePiece();
        fromPiece.speak();
        Piece attackedPiece = game.getBoardSquares()[toRow][toColumn].removePiece();
        game.getOpponentTeam().removePieceFromTeam(attackedPiece);
        game.getBoardSquares()[toRow][toColumn].setPiece(fromPiece);
        game.changeTurn();

        if (fromPiece instanceof PieceEvilMinion) {
            if (attackedPiece instanceof PieceMinion) {
                PieceEvilMinion eminion = new PieceEvilMinion();
                game.getOpponentTeam().addPieceToTeam(eminion);
                game.getBoardSquares()[fromRow][fromColumn].setPiece(eminion);
            }
        }

    }

}
