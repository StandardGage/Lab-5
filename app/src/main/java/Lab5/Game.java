package Lab5;

import java.util.Collections;

/**
 * Object that represents the an active game. Will start a GameBoard with the
 * teams,
 * set their pieces on the board, and alternates turns for each team.
 *
 * @author Faith Lovell and Gage Schuster
 * @version 2.0
 */
public abstract class Game {
    protected GameBoard board;
    protected Team team1;
    protected Team team2;
    protected String turn;

    /**
     * Creates a GameBoard instance with specified rows and columns,
     * and randomly places both team's pieces on the board.
     * 
     * @param numRows    number of rows on the board
     * @param numColumns number of columns on the board
     */
    private void initializeGameBoard(int numRows, int numColumns) {
        this.board = new GameBoard(numRows, numColumns);
        for (Piece teamPiece : team1.getTeamPieces()) {
            this.board.findRandomEmptySpace().setPiece(teamPiece);
        }
        for (Piece teamPiece : team2.getTeamPieces()) {
            this.board.findRandomEmptySpace().setPiece(teamPiece);
        }
        this.board.findRandomEmptySpace().setHiddenSquare(true); //Board Square Modification (randomly places hidden square)
    }

    public Game(int rows, int columns, Team team1, Team team2) {
        this.turn = team1.getTeamColor();
        this.team1 = team1;
        this.team2 = team2;
        initializeGameBoard(rows, columns);
    }

    public GameBoard getGameBoard() {
        return this.board;
    }

    public Team getCurrentTeam() {
        if (this.turn.equals(this.team1.getTeamColor())) {
            return this.team1;
        } else {
            return this.team2;
        }
    }

    public Team getOpponentTeam() {
        if (this.turn.equals(this.team1.getTeamColor())) {
            return this.team2;
        } else {
            return this.team1;
        }
    }

    /**
     * Checks if it is the given team's turn
     * 
     * @param team team whose turn will be checked
     * @return boolean true if it is the team's turn, otherwise false
     */
    public boolean isTurn(Team team) {
        return this.getCurrentTeam() == team;
    }

    public BoardSquare[][] getBoardSquares() {
        return this.board.getSquares();
    }

    /**
     * Alternates turns between the two teams;
     * changes turn color to the opponent team's color.
     */
    public void changeTurn() {
        //will make sure abducted pieces that lost a turn will get their turn back
        for(Piece teamPiece : getOpponentTeam().getTeamPieces()){
            teamPiece.setAbducted(teamPiece.abductedTimer - 1);
        }
        for(Piece teamPiece : getCurrentTeam().getTeamPieces()){
            teamPiece.setAbducted(teamPiece.abductedTimer - 1);
        }
        this.turn = getOpponentTeam().getTeamColor();
    }

    public abstract boolean isAWinner();

    public abstract Team getWinner();

    public abstract boolean isGameEnded();

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }

}
