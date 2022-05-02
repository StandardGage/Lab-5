package Lab5;

public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);
    public abstract boolean validRecruitPath(int rowRecruiter, int columnRecruiter, int rowRecruit, int columnRecruit);
}
