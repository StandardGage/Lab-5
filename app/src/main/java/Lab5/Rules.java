package Lab5;

/**
 * This class contains the rules for each type of piece in the game.
 * Determines what a piece can and cannot do.
 *
 * @authors Faith Lovell and Gage Schuster
 * @version 1.0
 */
public class Rules {

    /**
     * Determines whether given square has a piece,
     * and whether that piece is part of the current team
     * @param game
     * @param fromSquare
     * @return true if piece exists and is part of the current team
     */
    public static boolean pieceExists(GameS22 game, BoardSquare fromSquare) {
        if(fromSquare.isEmpty()) {
            System.out.println("\nThere is no piece here.\n");
            return false;
        }
        Piece fromPiece = fromSquare.getPiece();
        if(!fromPiece.getTeamColor().equals(game.getCurrentTeam().getTeamColor())) {
            System.out.println("\nThis is the enemy's piece.\n");
            return false;
        }
        if(fromPiece.isAbducted()){
            System.out.println("\nThis piece is currently abducted.\n");
            return false;
        }
        System.out.println("\nYou chose piece " + fromPiece.toString());
        return true;
    }

    public static void name() {
        
    }

    /**
     * Determines if the piece in a certain square can move to another/perform an
     * action on the piece it is going to.
     * @param game current game being played
     * @param fromRow index of row the piece is coming from
     * @param fromColumn index of column the piece is coming from
     * @param toRow index of row the piece is moving to
     * @param toColumn index of column the piece is moving to
     * @param actionType char M (move), S (spawn), R (recruit), A(attack), or T(teleport)
     * @return true if the move can be made, otherwise false
     */
    public static boolean checkValidAction(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn, char actionType) {
        BoardSquare fromSquare = game.getBoardSquares()[fromRow][fromColumn];
        BoardSquare toSquare = game.getBoardSquares()[toRow][toColumn];
        Piece fromPiece = fromSquare.getPiece();
        boolean validAction = false;
        
        switch (actionType) {
            //I split a lot of the if statements up in the cases just for readability
            //ex I know in case S I could combine it to (fromPiece.canSpawn() && toSquare.isEmpty)
            //was just easier to do so we can make sure all rules are covered step-by-step
            case 'M':
                if(fromPiece.validMovePath(fromRow, fromColumn, toRow, toColumn) && toSquare.isEmpty()) { //path is valid
                    validAction = true;
                } else {
                    System.out.println("\nYour chosen piece cannot move here.");
                }
                break;

            case 'S':
                if(fromPiece.validSpawnPath(fromRow, fromColumn, toRow, toColumn)) { //path is valid
                    //check if piece can spawn
                    if (fromPiece.canSpawn()) {
                        //checks to square is empty
                        if (toSquare.isEmpty()) {
                            //PieceMinion spawn path
                            if (fromPiece instanceof PieceMinion) {
                                //determining closest corner
                                int endRow = game.getGameBoard().getNumRows() - 1;
                                int endColumn = game.getGameBoard().getNumColumns() - 1;
                                int distBottomLeft = (int) Math.sqrt((endRow - fromRow) * (endRow - fromRow) + (fromColumn) * (fromColumn));
                                int distTopLeft = fromRow + fromColumn;
                                int distBottomRight = (int) Math.sqrt((endRow - fromRow) * (endRow - fromRow) + (endColumn - fromColumn) * (endColumn - fromColumn));
                                int distTopRight = (int) Math.sqrt((fromRow) * (fromRow) + (endColumn - fromColumn) * (endColumn - fromColumn));
                                //finding closest corner
                                int shortestDist;
                                if (distBottomLeft < distTopLeft && distBottomLeft < distBottomRight && distBottomLeft < distTopRight) {
                                    shortestDist = distBottomLeft;
                                } else if (distTopLeft < distBottomLeft && distTopLeft < distBottomRight && distTopLeft < distTopRight) {
                                    shortestDist = distTopLeft;
                                } else if (distBottomRight < distBottomLeft && distBottomRight < distTopRight && distBottomRight < distTopLeft) {
                                    shortestDist = distBottomRight;
                                } else if (distTopRight < distBottomLeft && distTopRight < distBottomRight && distTopRight < distTopLeft) {
                                    shortestDist = distBottomLeft;
                                } else { //in case all distances are equal
                                    shortestDist = -1;
                                }
                                //checking if move is valid (finally)
                                //all distances equal (any corner valid)
                                if ((toRow == 0 && toColumn == 0) || (toRow == endRow && toColumn == 0) || (toRow == 0 && toColumn == endColumn) || (toRow == endRow && toColumn == endColumn)) {
                                    validAction = true;
                                }
                                //top left
                                if ((toRow == 0 && toColumn == 0) && (shortestDist == distTopLeft)) {
                                    validAction = true;
                                }
                                //bottom left
                                if ((toRow == endRow && toColumn == 0) && (shortestDist == distBottomLeft)) {
                                    validAction = true;
                                }
                                //top right
                                if ((toRow == 0 && toColumn == endColumn) && (shortestDist == distTopRight)) {
                                    validAction = true;
                                }
                                //bottom right
                                if ((toRow == endRow && toColumn == endColumn) && (shortestDist == distBottomRight)) {
                                    validAction = true;
                                }
                            } else {
                                validAction = true;
                            }
                        }
                    }
                }
                if(!validAction) {
                    System.out.println("\nYour chosen piece cannot spawn here.");
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
                            //PieceSpaceship can only interact with Aliens
                            //New Extended Piece Modification
                            if (fromPiece instanceof PieceSpaceship) {
                                if (toSquare.getPiece() instanceof PieceAlien){
                                    validAction = true;
                                } else {
                                    validAction = false;
                                }
                            }
                        }
                    }
                }
                if (!validAction) {
                    System.out.println("\nYour chosen piece cannot recruit here.");
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
                                //PieceAlien can't attack Buzz
                                //New Piece Modification
                                if (fromPiece instanceof PieceAlien){
                                    if (toSquare.getPiece() instanceof PieceBuzz){
                                        validAction = true;
                                    }
                                }
                                //PieceSpaceship can only interact with Aliens
                                //New Extended Piece Modification
                                if (fromPiece instanceof PieceSpaceship) {
                                    if (toSquare.getPiece() instanceof PieceAlien){
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
                if (!validAction) {
                    System.out.println("\nYour chosen piece cannot attack here.");
                }
                break;

            //New Action Modification (added to rules)
            case 'T':
                //has to have piece on toSquare
                if(!(toSquare.isEmpty())) {
                    //New Piece Modification (Aliens can't perform new action)
                    if(!(fromPiece instanceof PieceAlien && !(fromPiece instanceof PieceSpaceship))){
                        //Spaceships can always use teleport & can only interact with aliens
                        //New Extended Piece Modification
                        if(fromPiece instanceof PieceSpaceship) {
                            if (toSquare.getPiece() instanceof PieceAlien) {
                                validAction = true;
                            }
                        }
                        //total teleports has to be below limit
                        else{
                            if(game.getTotalTeleports() < game.getMaxTeleports()){ //New Rule Modification (limits amount of teleports for non-aliens)
                                //if fromPiece is within one(non diagonal) space of a PieceAlien
                                if(game.getBoardSquares()[fromRow + 1][fromColumn].getPiece() instanceof PieceAlien ||
                                        game.getBoardSquares()[fromRow - 1][fromColumn].getPiece() instanceof PieceAlien ||
                                        game.getBoardSquares()[fromRow][fromColumn + 1].getPiece() instanceof PieceAlien ||
                                        game.getBoardSquares()[fromRow][fromColumn - 1].getPiece() instanceof PieceAlien){
                                    validAction = true;
                                }
                            }
                        }

                        }
                    }
                if (!validAction) {
                    System.out.println("\nYour chosen piece cannot use teleport.");
                }
                break;
        }
        return validAction;
    }
}
