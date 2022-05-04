package Lab5;

public class ActionRecruit extends Action {

    public ActionRecruit(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
        fromPiece.speak();
        game.getOpponentTeam().removePieceFromTeam(fromPiece);
        game.getCurrentTeam().addPieceToTeam(fromPiece);
        game.changeTurn();
    }

}
