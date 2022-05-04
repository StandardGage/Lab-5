package Lab5;

/**
 * Interface for pieces that can recruit other pieces in the game.
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public interface Recruiter {
    public int getNumRecruits();

    public void setNumRecruits(int numRecruits);

    public boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruit, int columnRecruit);
}
