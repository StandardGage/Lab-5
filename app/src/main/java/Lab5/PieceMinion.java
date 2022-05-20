package Lab5;

public class PieceMinion extends Piece implements Recruiter {
    private int numRecruits;
    private int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor,
            int numRecruits, int numTimesSpawned,
            boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original, 0);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion() {
        this('M', "- -",
                0, 0,
                false, true);
    }

    public int getNumRecruits() {
        return numRecruits;
    }

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    /**
     * Implemented this function
     * not sure how canspawn would
     * have any effect without it
     * 
     * @author Gage Schuster
     */
    public void incrementNumTimesSpawned() {
        numTimesSpawned += 1;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruit, int columnRecruit) {
        return validMovePath(rowRecruiter, columnRecruiter, rowRecruit, columnRecruiter);
    }

    public void speak() {
        System.out.println("Bello!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol) {
        if(fromSquareCol == toSquareCol){
            return true;
        } //mutually exclusive
        return fromSquareRow == toSquareRow && Math.abs(fromSquareCol - toSquareCol) == 2;
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true; //implemented in rules
    }

    public PieceMinion spawn() {
        // added this line so canspawn actually has a use
        incrementNumTimesSpawned();
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor, 1,
                0,
                false,
                false);
    }

    public boolean canSpawn() {
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

}
