package Lab5;

/**
 * Class that represents the game being made for the Spring 2022 Semester and its unique rules.
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */

public class GameS22 extends Game {
    private int totalTeleports;
    private int maxTeleports;


    public GameS22(int numRows, int numColumns, Team team1, Team team2){
        super(numRows, numColumns, team1, team2);
        this.totalTeleports = 0;
        this.maxTeleports = (int) (Math.random() * 75); //New Rule Modification (there are a max amount of teleports)
    }

    //New Rule Modification
    public void setTotalTeleports(int teleports){this.totalTeleports = teleports;}
    public int getTotalTeleports(){return this.totalTeleports;}
    public int getMaxTeleports(){return this.maxTeleports;}


    /**
     * Determines if there is a winner
     * @return true if there is, otherwise false (ex. case of a tie)
     */
    @Override
    public boolean isAWinner() {
        return getWinner() != null;
    }

    /**
     * Checks if opponents side's first two rows is full of other team's
     * @return winner of game, null if there is none
     */
    //New Objective Modification
    @Override
    public Team getWinner() {
        Team winner = team1;
        for (BoardSquare square : board.getSquares()[0]) {
            if (square.getPiece() == null || !square.getPiece().getTeamColor().equals(team1.getTeamColor())) {
                winner = null;
                break;
            }
        }
        if (winner == team1) {
            for (BoardSquare square : board.getSquares()[1]) {
                if (square.getPiece() == null || !square.getPiece().getTeamColor().equals(team1.getTeamColor())) {
                    winner = null;
                    break;
                }
            }
        }
        if(winner == team1) {
            return winner;
        }
        winner = team2;
        for (BoardSquare square : board.getSquares()[6]) {
            if (square.getPiece() == null || !square.getPiece().getTeamColor().equals(team2.getTeamColor())) {
                winner = null;
                break;
            }
        }
        if (winner == team2) {
            for (BoardSquare square : board.getSquares()[7]) {
                if (square.getPiece() == null || !square.getPiece().getTeamColor().equals(team2.getTeamColor())) {
                    winner = null;
                    break;
                }
            }
        }
        return winner;
    }

    //New Objective Modification
    /**
     * Shows whether the game is over or not
     * @return true if there is a winner
     */
    @Override
    public boolean isGameEnded() {
        return getWinner() != null;
    }

}
