package Lab5;

public class ActionMove extends Action{
    //represent an action the user can take where they move their own piece from the first square
    //on the board to the second square on the board

    public ActionMove(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    public void performAction() {
        Piece fromPiece = game.getBoardSquares()[fromRow][fromColumn].getPiece();
        fromPiece.speak();
        game.getBoardSquares()[fromRow][fromColumn].removePiece();
        game.getBoardSquares()[toRow][toColumn].setPiece(fromPiece);
        game.changeTurn();
    }
}
