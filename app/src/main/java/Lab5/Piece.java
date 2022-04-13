package Lab5;

/**
 * Basic Piece class for all game pieces.
 * Has symbol, team color, hidden, and original property constructors,
 * getters, and setters for each property. Includes spawn (canSpawn and spawn),
 * toString, and speak methods as well.
 *
 * @author Faith Lovell and Gage Schuster
 * @version 1.0
 */
abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    public Piece(char symbol, String teamColor, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    public abstract void speak();

    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol);

    public abstract boolean canSpawn();

    public abstract Piece spawn();

    @Override
    public String toString() {
        return teamColor + " " + symbol;
    }
}
