public class PieceBuzz {
    private char symbol;
    private String teamColor;
    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;
    private boolean hidden;
    private boolean original;

    public PieceBuzz(char symbol,
                      String teamColor,
                      int numAttacks,
                      int numTimesBeenAttacked,
                      boolean workingLaser,
                      boolean hidden,
                      boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
        this.hidden = hidden;
        this.original = original;
    }

    public PieceBuzz(){
        this('B',"- -",
                0,0,
                true, false, true);
    }

    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public int getNumAttacks() {
        return numAttacks;
    }
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    public boolean canAttack(){
        return workingLaser;
    }
    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal(){ return original;}

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
       this.original = original; 
    }

    public void setNumAttacks(int numAttacks)  {
     this.numAttacks = numAttacks;
    }

    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }
    public Piece spawn(){
        return null;
    }
    public boolean canSpawn(){
        return false;
    }

}
