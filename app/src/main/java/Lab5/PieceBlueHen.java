package Lab5;

public class PieceBlueHen extends Piece implements Recruiter, Attacker {
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen(char symbol,
            String teamColor,
            int numAttacks, int numRecruits,
            boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original, 0);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen() {
        this('H', "NON",
                0, 0,
                false, true);
    }

    public int getNumAttacks() {
        return this.numAttacks;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }

    public boolean canFly() {
        return this.flies;
    }

    @Override
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
        updateFly();
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    private void updateFly() {
        if (this.numAttacks < MAX_NUM_ATTACKS) {
            this.flies = true;
        } else {
            this.flies = false;
        }
    }

    public void speak() {
        System.out.println("Go UD!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol) {
        if(canFly()){
            return true;
        }
        // toSquares are within 1 square from fromSquares in any direction
        return Math.abs(fromSquareRow - toSquareRow) <= 1 && Math.abs(fromSquareCol - toSquareCol) <= 1;
    }

    public PieceBlueHen spawn() {
        PieceBlueHen copyHen = new PieceBlueHen(Character.toLowerCase(this.symbol),
                this.teamColor, this.numAttacks, this.numRecruits,
                false, false);
        return copyHen;
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if(canFly()){
            return true;
        }
        //diagonals
        return Math.abs(fromSquareRow - toSquareRow) == 1 && Math.abs(fromSquareCol - toSquareCol) == 1;
    }

    public boolean canSpawn() {
        return true;
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruit, int columnRecruit) {
        if(canFly()){
            return true;
        }
        return columnRecruit == columnRecruiter && Math.abs(rowRecruit - rowRecruiter) == 1;
    }

    @Override
    public boolean validAttackPath(int rowAttacking, int columnAttacking, int rowAttacked, int columnAttacked) {
        if(canFly()){
            return true;
        }
        return rowAttacked == rowAttacking && Math.abs(columnAttacked - columnAttacking) == 1;
    }
}

