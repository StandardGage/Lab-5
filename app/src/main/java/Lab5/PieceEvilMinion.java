package Lab5;

/**
 * Piece based on Evil Minions from Despicable Me. All traits are mostly identical
 * to PieceMinion class, but with an extra attack property. This piece attacks
 * pieces, and when they do, that piece is removed from the game. Can also
 * convert minion Pieces.
 *
 * @author Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class PieceEvilMinion extends PieceMinion implements Attacker {
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
        return this.numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int rowAttacking, int columnAttacking, int RowAttacked, int columnAttacked) {
        return true;
    }

    public void updateHungry() {
        this.hungry = numAttacks < MAX_NUM_ATTACKS;
    }

    public void speak() {
        System.out.println("Roar!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // TODO: implement later
        return true;
    }

    /**
     * Spawns a new PieceEvilMinion
     * @return new PieceEvilMinion with lowercase symbol, team color, 1 recruit, 0 attacks,
     * 0 times spawned, not hidden, not original, and hungry.
     */
    public PieceEvilMinion spawn() {
        incrementNumTimesSpawned();
        return new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0, 0, false, false);
    }

    public boolean canAttack() {
        return this.hungry;
    }

}
