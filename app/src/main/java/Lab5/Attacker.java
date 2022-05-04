package Lab5;

/**
 * Interface for pieces that can attack in the game.
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public interface Attacker {
    public int getNumAttacks();

    public void setNumAttacks(int numAttacks);

    public boolean validAttackPath(int rowAttacking, int columnAttacking, int RowAttacked, int columnAttacked);
}
