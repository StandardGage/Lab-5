package Lab5;

public class GameS22 extends Game {
    public GameS22(int numRows, int numColumns, Team team1, Team team2){
        super(numRows, numColumns, team1, team2);
    }

    @Override
    public boolean isAWinner() {
        return getWinner() != null;
    }

    @Override
    public Team getWinner() {
        Team winner = null;
        if(!(team1.getTeamPieces().isEmpty()) && !(team2.getTeamPieces().isEmpty())){
            return null;
        }
        else if(team1.getTeamPieces().isEmpty()){
            winner = team2;
        }
        else if(team2.getTeamPieces().isEmpty()){
            winner = team1;
        }
        return winner;
    }

    @Override
    public boolean isGameEnded() {
        return team1.getTeamPieces().isEmpty() || team2.getTeamPieces().isEmpty();
    }

}
