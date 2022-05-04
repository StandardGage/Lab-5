package Lab5;

public class ActionSpawn extends Action {

    public ActionSpawn(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
        fromPiece.speak();
        Piece spawnPiece = fromPiece.spawn();
        game.getCurrentTeam().addPieceToTeam(spawnPiece);
        game.getBoardSquares()[toRow][toColumn].setPiece(spawnPiece);
        game.changeTurn();
    }

}
