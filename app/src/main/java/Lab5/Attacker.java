package Lab5;

public interface Attacker {
    public int getNumAttacks();

    public void setNumAttacks(int numAttacks);

    public boolean validAttackPath(int rowAttacking, int columnAttacking, int RowAttacked, int columnAttacked);
}
