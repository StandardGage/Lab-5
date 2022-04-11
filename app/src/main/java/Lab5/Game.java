package Lab5;

import java.util.Collections;

public class Game {
    private GameBoard board;
    private Team team1;
    private Team team2;
    private String turn;

    private void initializeGameBoard(int numRows, int numColumns){
        this.board = new GameBoard(numRows, numColumns);
        for(Piece teamPiece : team1.getTeamPieces()){
            this.board.findRandomEmptySpace().setPiece(teamPiece);
        }
        for(Piece teamPiece : team2.getTeamPieces()){
            this.board.findRandomEmptySpace().setPiece(teamPiece);
        }
    }

    public Game(int rows, int columns, Team team1, Team team2){
        this.turn = team1.getTeamColor();
        this.team1 = team1;
        this.team2 = team2;
        initializeGameBoard(rows, columns);
    }

    public GameBoard getGameBoard(){
        return this.board;
    }

    public Team getCurrentTeam(){
        if(this.turn.equals(this.team1.getTeamColor())){
            return this.team1;
        }
        else{
            return this.team2;
        }
    }

    public Team getOpponentTeam(){
        if(this.turn.equals(this.team1.getTeamColor())){
            return this.team2;
        }
        else{
            return this.team1;
        }
    }

    public boolean isTurn(Team team){
        return this.getCurrentTeam() == team;
    }

    public BoardSquare[][] getBoardSquares(){
        return this.board.getSquares();
    }

    public void changeTurn(){
        this.turn = getOpponentTeam().getTeamColor();
    }

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
