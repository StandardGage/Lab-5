package Lab5;

//New Extended Piece Modification
public class PieceSpaceship extends PieceAlien{

    public PieceSpaceship(char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden, boolean original){
        super(symbol, teamColor, numAttacks, numRecruits, hidden, original);
    }

    public PieceSpaceship(){
        this('S', "NON",
                0, 0,
                false, true);
    }

    @Override
    public boolean validAttackPath(int rowAttacking, int columnAttacking, int rowAttacked, int columnAttacked) {
        return true; //spaceships can fly, can go anywhere
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruit, int columnRecruit) {
        //all directions by one square:
        //non-diagonals
        if ((rowRecruit == rowRecruiter && columnRecruit == columnRecruiter + -1) || (rowRecruit == rowRecruiter + -1 && columnRecruiter == columnRecruit)) {
            return true;
        }
        //diagonal
        else if ((rowRecruit == rowRecruiter + -1) && (columnRecruit == columnRecruiter + -1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true; //spaceships can fly, can go anywhere
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }

    @Override
    public boolean canSpawn(){
        return false;
    }

    @Override
    public Piece spawn(){
        return null; //can't spawn
    }

    @Override
    public void speak(){
        System.out.println("⌇⌿⏃☊⟒⌇⊑⟟⌿"); //this also may break something
    }

}
