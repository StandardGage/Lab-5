package Lab5;

import java.util.ArrayList;

/**
 * Represents the team in a game. Holds the team's color and all of their
 * pieces, and can add and remove pieces to and from the team.
 *
 * @author Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class Team {
    private String teamColor;
    private ArrayList<Piece> teamPieces;

    public Team(String color, ArrayList<Piece> pieces){
        this.teamColor = color;
        this.teamPieces = pieces;
    }

    public String getTeamColor(){
        return this.teamColor;
    }

    public ArrayList<Piece> getTeamPieces(){
        return this.teamPieces;
    }

    /**
     * Removes given Piece from teamPieces
     * @param removed the piece that should be removed.
     */
    public void removePieceFromTeam(Piece removed){
        this.teamPieces.remove(removed);
    }

    /**
     * Adds given piece to teamPieces and sets its team color.
     * @param added piece to be added.
     */
    public void addPieceToTeam(Piece added){
        added.setTeamColor(this.teamColor);
        this.teamPieces.add(added);
    }

    @Override
    public String toString(){
        String pieces = "Team " + this.teamColor + " Pieces :\n";
        for(Piece teamPiece: this.teamPieces){
            pieces += teamPiece.toString() + " ";
        }
        return pieces + "\n";
    }
}
