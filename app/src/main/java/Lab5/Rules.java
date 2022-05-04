package Lab5;

/**
 * This class contains the rules for each type of piece in the game.
 * Determines what a piece can and cannot do.
 *
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class Rules {
//TODO: create some test cases & test rules, add docstrings

    /**
     * Determines if the piece in a certain square can move to another/perform an
     * action on the piece it is going to.
     * @param game current game being played
     * @param fromRow index of row the piece is coming from
     * @param fromColumn index of column the piece is coming from
     * @param toRow index of row the piece is moving to
     * @param toColumn index of column the piece is moving to
     * @param actionType char M (move), S (spawn), R (recruit), or A(attack)
     * @return true if the move can be made, otherwise false
     */
    public static boolean checkValidAction(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn, char actionType) {
        BoardSquare fromSquare = game.getBoardSquares()[fromRow][fromColumn];
        BoardSquare toSquare = game.getBoardSquares()[toRow][toColumn];
        Piece fromPiece = fromSquare.getPiece();
        boolean validAction = false;
        boolean toFromBounds = false;
        boolean fromIsCurrentTeam = false;
        boolean validPath = false;

        //checks four conditions necessary for each rule: indexes in bounds, from piece exists & belongs to current team,
        // & to-from path is valid.
        if (game.getGameBoard().inBounds(fromRow, fromColumn) || game.getGameBoard().inBounds(toRow, toColumn)) {
            toFromBounds = true;
        }
        if (!(fromSquare.isEmpty()) && fromPiece.getTeamColor().equals(game.getCurrentTeam().getTeamColor())) {
            fromIsCurrentTeam = true;
        }
        if(fromPiece.validMovePath(fromRow, fromColumn, toRow, toColumn)) { //path is valid
            validPath = true;
        }
            if (toFromBounds && fromIsCurrentTeam && validPath) {
            switch (actionType) {
                //I split a lot of the if statements up in the cases just for readability
                //ex I know in case S I could combine it to (fromPiece.canSpawn() && toSquare.isEmpty)
                //was just easier to do so we can make sure all rules are covered step-by-step
                case 'M':
                    if(toSquare.isEmpty()){ //no piece on to square
                        validAction = true;
                    }
                    break;

                case 'S':
                    //check if piece can spawn
                    if(fromPiece.canSpawn()){
                        //checks to square is empty
                        if(toSquare.isEmpty()){
                            validAction = true;
                        }
                    }
                    break;

                case 'R':
                    //check if piece is recruiter
                    if(fromPiece instanceof Recruiter) {
                        //check if valid recruit path
                        if (((Recruiter) fromPiece).validRecruitPath(fromRow, fromColumn, toRow, toColumn)) {
                            //check if toSquare contains piece
                            if (!(toSquare.isEmpty())) {
                                //check if toSquare piece belongs to Opponent team
                                if (toSquare.getPiece().getTeamColor().equals(game.getOpponentTeam().getTeamColor())) {
                                    validAction = true;
                                }
                            }
                        }
                    }
                    break;

                case 'A':
                    //check if piece on toSquare
                    if(!(toSquare.isEmpty())) {
                        //check if piece is attacker
                        if (fromPiece instanceof Attacker) {
                            //checks if there is a valid attack path
                            if (((Attacker) fromPiece).validAttackPath(fromRow, fromColumn, toRow, toColumn)) {
                                //checks if to piece is opponent piece
                                if (toSquare.getPiece().getTeamColor().equals(game.getOpponentTeam().getTeamColor())) {
                                    //all attackers can attack opponents, so:
                                    //PieceBlueHen can automatically attack opponent
                                    if (fromPiece instanceof PieceBlueHen) {
                                        validAction = true;
                                    }
                                    //PieceBuzz working laser
                                    if (fromPiece instanceof PieceBuzz) {
                                        if (((PieceBuzz) fromPiece).canAttack()) {
                                            validAction = true;
                                        }
                                    }
                                    //PieceEvilMinion hungry
                                    if (fromPiece instanceof PieceEvilMinion) {
                                        if (((PieceEvilMinion) fromPiece).canAttack()) {
                                            validAction = true;
                                        }
                                    }
                                }
                                else{
                                    //if to piece is current team, evil minion may attack...
                                    if(fromPiece instanceof PieceEvilMinion){
                                        if (((PieceEvilMinion) fromPiece).canAttack()){
                                            //...if to piece is a minion
                                            if(toSquare.getPiece() instanceof PieceMinion){
                                                validAction = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return validAction;
    }
}
