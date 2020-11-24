package Controller;

import Models.Board.Board;
import Models.Board.Die;
import Models.Board.Field;
import Models.Player.PieceSelector;
import Models.Player.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class GameController {
    public PlayerController playerController;
    public Board board;
    public Die die;
    public BoardController boardController;
    private PieceSelector pieceSelector;


    public GameController() {
        this.board = new Board();
        this.die = new Die();
        this.boardController = new BoardController();
        this.pieceSelector = new PieceSelector(boardController.getGUIBoard());


        playerController = new PlayerController(4);

    }

    // returnere felt spilleren står på
    public Field getCurrentField(Player currentPlayer) {
        return this.board.field[currentPlayer.getPosition()];
    }

    public boolean canBuyField(Player currentPlayer) {
        Field currentField = getCurrentField(currentPlayer);
        return currentField.getPropertyOwner() == null;

    }

    //Returne om hvis balance er større end field price
    public boolean checkAccount(Player currentPlayer, Field currentField) {
        return currentPlayer.getAccount().getBalance() >= currentField.getPrice();


    }

    // Sætter currentspiller til FieldOwner og trækker feltets værdi fra spillerens account
    public void buyField(Player currentPlayer) {
        Field currentField = getCurrentField(currentPlayer);
        currentField.setPropertyOwner(currentPlayer);
        currentPlayer.getAccount().addPoint(-currentField.getPrice());


    }

    public boolean gameEnd(PlayerController pc) {
        boolean gameEnd = false;
        for (int i = 0; i < pc.getNumPlayers(); i++) {
            if (pc.getPlayer(i).getAccount().getBalance() <= 0)
                gameEnd = true;
        }
        return gameEnd;
    }

    // gameloop
    // ! -> ikke
    public void runGame() {
        GUI gui = boardController.getGUIBoard();
        //Scanner scanner = new Scanner(System.in);
        playerController.setCurrentPlayer(0);

        for (int i = 0; i < playerController.getNumPlayers(); i++) {
            //brug i stedet GUI i stedet for terminal. få fat i den gennem boardcontroller.
            System.out.println(" Angiv dit navn ");
            //String name = scanner.nextLine();
            //Hent brugerens navn og gem det.
            String name = gui.getUserString("Angiv dit navn");
            playerController.getPlayer(i).setName(name);

            GUI_Car car = pieceSelector.pieceselect();
            GUI_Player player = new GUI_Player(name, 20, car);
            gui.addPlayer(player);

        }
        //i et forloop gennemgås modelspillerne. find deres navne opret GUI spiller med samme navne. GUIspillerne gives til controlleren.

        while (!gameEnd(playerController)) {
            // hvilken spiller vi har fat i
            Player p = playerController.getCurrentPlayer();
            System.out.println("start runde " + p.getName() + " tryk enter");
            //scanner.nextLine();
            gui.getUserButtonPressed("Tryk på knappen" , "OK");
            System.out.println(p.getPosition() + " nuværende position ");


            //bevæger spiller med terningekast.
            int roll = die.roll();
            p.movePlayer(roll);
            gui.setDie(roll);
            System.out.println(p.getPosition() + " ny position " + "har kastet en " + die.getFaceValue());
            boardController.landedOn(p, board);
            playerController.switchPlayer();

        }


    }
}
