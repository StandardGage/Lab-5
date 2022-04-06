package Lab5;

public class PieceEvilMinion extends PieceMinion {
    private int numAttacks;
    private boolean hungry;

    final public int MAX_NUM_ATTACKS = 4;

    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned,
            boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    public PieceEvilMinion() {
        this('E', "NON", 0, 0, 0, false, true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public void updateHungry() {
        hungry = numAttacks < MAX_NUM_ATTACKS;
    }

    public void speak() {
        System.out.println("Roar!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // TODO: implement later
        return true;
    }

    public PieceEvilMinion spawn() {
        incrementNumTimesSpawned();
        return new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0, 0, false, false);
    }

    public boolean canAttack() {
        return hungry;
    }
}
