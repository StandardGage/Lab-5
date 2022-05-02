package Lab5;

abstract class Action {
    protected GameS22 game;
    protected int fromRow;
    protected int fromColumn;
    protected int toRow;
    protected int toColumn;

    public Action(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        this.game = game;
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
    }

    public abstract void performAction();

}
