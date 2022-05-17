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
abstract class Piece implements Comparable<Piece> {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;
    protected int abductedTimer;

    public Piece(char symbol, String teamColor, boolean hidden, boolean original, int abductedTimer) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
        this.abductedTimer = abductedTimer;
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

    public void setAbducted(int abducted) {
        this.abductedTimer = abducted;
    }

    public boolean isAbducted() {
        return abductedTimer != 0;
    }



    public abstract void speak();

    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol);

    public abstract boolean canSpawn();

    public abstract Piece spawn();

    public abstract boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                           int toSquareRow, int toSquareCol);

    @Override
    public String toString() {
        return teamColor + " " + symbol;
    }


    //FIXME: wtf is wrong with this... is my intelliJ just bugging?
    @Override
    public int compareTo(Piece other) {
        return symbol.compareTo(other.symbol);
    }
}
