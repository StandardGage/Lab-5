package Lab5;

/**
 * Class that represents the game being made for the Spring 2022 Semester and its unique rules.
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */

public class GameS22 extends Game {
    public GameS22(int numRows, int numColumns, Team team1, Team team2){
        super(numRows, numColumns, team1, team2);
    }

    /**
     * Determines if there is a winner
     * @return true if there is, otherwise false (ex. case of a tie)
     */
    @Override
    public boolean isAWinner() {
        return getWinner() != null;
    }

    /**
     * Determines the winner of the game based on pieces on the board.
     * @return the team that has pieces on the board when its opponent has no pieces; can also
     * return null if there is no winner.
     */
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

    /**
     * Shows whether the game is over or not
     * @return true if one team has no pieces on the board, false otherwise
     */
    @Override
    public boolean isGameEnded() {
        return team1.getTeamPieces().isEmpty() || team2.getTeamPieces().isEmpty();
    }

}
