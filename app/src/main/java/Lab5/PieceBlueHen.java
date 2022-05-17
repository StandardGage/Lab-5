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
        super(symbol, teamColor, hidden, original);
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
        //non-diagonals
        else if((toSquareRow == fromSquareRow && toSquareCol == fromSquareCol +- 1) || (toSquareRow == fromSquareRow +-1 && fromSquareCol == toSquareCol)){
            return true;
        }
        //diagonal
        else if((toSquareRow == fromSquareRow +- 1) && (toSquareCol == fromSquareCol +- 1)){
            return true;
        }
        else{
            return false;
        }
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
        //diagonal
        else if((toSquareRow == fromSquareRow +- 1) && (toSquareCol == fromSquareCol +- 1)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean canSpawn() {
        return true;
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruit, int columnRecruit) {
        if(canFly()){
            return true;
        }
        else if(columnRecruiter == columnRecruit && rowRecruit == rowRecruiter +- 1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean validAttackPath(int rowAttacking, int columnAttacking, int rowAttacked, int columnAttacked) {
        if(canFly()){
            return true;
        }
        else if(rowAttacking == rowAttacked && columnAttacked == columnAttacking +- 1){
            return true;
        }
        else{
            return false;
        }
    }
}

