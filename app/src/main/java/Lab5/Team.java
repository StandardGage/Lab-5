package Lab5;

import java.util.ArrayList;

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

    public void removePieceFromTeam(Piece removed){
        this.teamPieces.remove(removed);
    }

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
