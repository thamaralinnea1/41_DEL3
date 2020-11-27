package Controller;

import Models.Board.Board;
import Models.Board.Die;
import Models.Board.Field;
import Models.Player.PieceSelector;
import Models.Player.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class GameController {
    public PlayerController playerController;
    public Board board;
    public Die die;
    public BoardController boardController;
    private PieceSelector pieceSelector;
    private GUI gui ;



    public GameController() {


        this.board = new Board();
        this.die = new Die();
        this.boardController = new BoardController();
        gui = boardController.getGUIBoard();


        int playeramunt = Integer.parseInt(gui.getUserButtonPressed("Vægler antal af spiller","2","3","4"));

        this.pieceSelector = new PieceSelector(boardController.getGUIBoard());


        playerController = new PlayerController(playeramunt);

    }

    // returnere felt spilleren står på
    public Field getCurrentField(Player currentPlayer) {
        return this.board.fields[currentPlayer.getPosition()];
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
            if (pc.getPlayer(i).getAccount().getBalance() >=25)
                gameEnd = true;
        }
        return gameEnd;
    }

    // gameloop
    // ! -> ikke
    public void runGame() {

        playerChoice();

        GUI_Field[] fields = gui.getFields();
        //Scanner scanner = new Scanner(System.in);
        playerController.setCurrentPlayer(0);



        for (int i = 0; i < playerController.getNumPlayers(); i++) {

            String name = gui.getUserString("Angiv dit navn");
            playerController.getPlayer(i).setName(name);
            GUI_Car car = pieceSelector.pieceselect();
            GUI_Player player = new GUI_Player(name, 20, car);
            playerController.setGUIPlayer(i, player);
            gui.addPlayer(player);
            gui.getFields()[0].setCar(player , true);


        }
        //i et forloop gennemgås modelspillerne. find deres navne opret GUI spiller med samme navne. GUIspillerne gives til controlleren.

        while (!gameEnd(playerController)) {
            // hvilken spiller vi har fat i
            Player p = playerController.getCurrentPlayer();
            GUI_Player gui_p = playerController.getCurrentGUIPlayer();
            System.out.println("start runde " + p.getName() + " tryk enter");
            //scanner.nextLine();
            gui.getUserButtonPressed("Tryk på knappen" , "OK");
            System.out.println(p.getPosition() + " nuværende position ");
            int oldPosition = p.getPosition();


            //bevæger spiller med terningekast.
            int roll = die.roll();
            if(die.getFaceValue() + p.getPosition() >= 23) {
                int newBalance = p.getAccount().getBalance() + 2;
                gui_p.setBalance(newBalance);
                p.getAccount().setBalance(newBalance);
            }
            p.movePlayer(roll);
            playerController.switchPlayer();
            gui.setDie(roll);
            int newPosition = p.getPosition();
            fields[oldPosition].setCar(gui_p, false);
            fields[newPosition].setCar(gui_p , true);
            System.out.println(p.getPosition() + " ny position " + "har kastet en " + die.getFaceValue());
            boardController.landedOn(p, board);


        }

        Player p = playerController.getCurrentPlayer();
        gui.showMessage("Du har vundet" +" "+ p.getName());

    }

    public void playerChoice(){
       String value = gui.getUserButtonPressed("Tryk slut spil for at slutte spillet, eller tryk nyt spil for at starte nyt spil ","Slut spil","Nyt Spil");
       if (value == "Sluk"){
           System.exit(0);
       }

    }
}
