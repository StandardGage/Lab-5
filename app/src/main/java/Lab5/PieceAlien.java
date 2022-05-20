package Lab5;

//New Piece Modification (whole piece's class)
public class PieceAlien extends Piece implements Attacker, Recruiter{
    private int numAttacks;
    private int numRecruits;

    public PieceAlien(char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original, 0);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
    }

    public PieceAlien(char symbol, String teamColor, boolean hidden, boolean original){
        this('A', "NON",
                0, 0,
                false, true);
    }


    @Override
    public int getNumAttacks() {
        return this.numAttacks;
    }

    @Override
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int rowAttacking, int columnAttacking, int rowAttacked, int columnAttacked) {
        //diagonals
        return Math.abs(rowAttacked - rowAttacking) == 1 && Math.abs(columnAttacked - columnAttacking) == 1;
    }

    @Override
    public int getNumRecruits() {
        return this.numRecruits;
    }

    @Override
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruit, int columnRecruit) {
        //3 spaces up/down
        return columnRecruit == columnRecruiter && Math.abs(rowRecruit - rowRecruiter) == 3;
    }

    @Override
    public void speak() {
        System.out.println("⏃⌰⟟⟒⋏"); //this might break something... make sure to double check
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //up or down by two squares
        return fromSquareCol == toSquareCol && Math.abs(fromSquareRow - toSquareRow) == 2;
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    @Override
    public Piece spawn() {
        return new PieceAlien(Character.toLowerCase(this.symbol), this.teamColor, 1, 0, false, false);
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // toSquares are within 1 square from fromSquares in any direction
        return Math.abs(fromSquareRow - toSquareRow) <= 1 && Math.abs(fromSquareCol - toSquareCol) <= 1;
    }
}
