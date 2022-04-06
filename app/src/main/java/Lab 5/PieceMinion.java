public class PieceMinion {
    private char symbol;
    private String teamColor;
    private int numRecruits;
    private int numTimesSpawned;
    private boolean hidden;
    private boolean original;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor,
                        int numRecruits, int numTimesSpawned,
                        boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
        this.hidden = hidden;
        this.original = original;
    }

    public PieceMinion(){
        this('M',"- -",
                0,0,
                false,true);
    }

    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }
    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal() {
        return original;
    }
   
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original){
      this.original = original; 
    }

    public void setNumRecruits(int numRecruits) {
       this.numRecruits = numRecruits;
    }

    public void speak(){
        System.out.println("Bello!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    public PieceMinion1 spawn(){
        return new PieceMinion1(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

}
