package Lab5;

import java.util.ArrayList;

public class Controller {
    GameS22 game;
    TextView view;

    public GameS22 setUpGameModel() {
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M', "Blu",
                0, 0, false, true));
        piecesTeamA.add(new PieceBuzz('B', "Blu", 2, 1,
                true, false, true));
        piecesTeamA.add(new PieceBlueHen('H', "Blu", 3,
                9, false, true));
        piecesTeamA.add(new PieceEvilMinion('E', "Blu", 1,
                1, 4, false, true));
        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M', "Red",
                0, 0, false, true));
        piecesTeamB.add(new PieceBlueHen('H', "Red", 3,
                9, false, true));
        piecesTeamB.add(new PieceBuzz('B', "Red", 2, 1,
                true, false, true));
        piecesTeamB.add(new PieceEvilMinion('E', "Red", 1,
                1, 4, false, true));
        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8, teamA, teamB);
    }

    public Controller() {
        game = setUpGameModel();
        view = new TextView();
        view.updateView(game);
    }

    public void carryOutAction(int fromRow, int fromColumn, int toRow, int toColumn, char action) {
        switch (action) {
            case 'M':
                ActionMove move = new ActionMove(game, fromRow, fromColumn, toRow, toColumn);
                move.performAction();
                break;
            case 'A':
                ActionAttack attack = new ActionAttack(game, fromRow, fromColumn, toRow, toColumn);
                attack.performAction();
                break;
            case 'R':
                ActionRecruit recruit = new ActionRecruit(game, fromRow, fromColumn, toRow, toColumn);
                recruit.performAction();
                break;
            default:
                System.out.println("Invalid Action Recieved");
                break;
        }
    }

    public void playGame() {
        boolean valid;
        while (game.isGameEnded() == false) {
            do {
                view.getNextPlayersAction(game);
                // TODO: check this
                valid = Rules.checkValidAction(game, view.fromRow, view.fromColumn, view.toRow, view.toColumn,
                        view.action);
            } while (valid == false);
            carryOutAction(view.fromRow, view.fromColumn, view.toRow, view.toColumn, view.action);
            System.out.println(game);
        }
        view.printEndOfGameMessage(game);

    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }
}
