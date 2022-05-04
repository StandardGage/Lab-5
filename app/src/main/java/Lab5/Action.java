package Lab5;

/**
 * Will represent the actions that pieces can do during the game.
 * Includes five member fields, a constructor, and performAction method.
 *
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */

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
