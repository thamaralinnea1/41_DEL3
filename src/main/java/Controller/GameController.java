package Controller;


import Models.Board.Board;
import Models.Board.Die;
import Models.Board.Field;
import Models.Player.PieceSelector;
import Models.Player.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class GameController {

    private PlayerController playerController;
    public Board board;
    public Die die;
    public BoardController boardController;
    private PieceSelector pieceSelector;
    private GUI gui;


    public GameController() {

        this.board = new Board();
        this.die = new Die();
        this.boardController = new BoardController();
        gui = boardController.getGUIBoard();

        playerChoice();

        int playerAmount = Integer.parseInt(gui.getUserButtonPressed("Vælg antal af spillere", "2", "3", "4"));
        playerController = new PlayerController(playerAmount);
        this.pieceSelector = new PieceSelector(boardController.getGUIBoard());
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
    public boolean checkAccount(Player currentPlayer) {
        Field currentField= getCurrentField(currentPlayer);
        return currentPlayer.getAccount().getBalance() >= currentField.getPrice();
    }

    // Sætter currentspiller til FieldOwner og trækker feltets værdi fra spillerens account
    public void buyField(Player currentPlayer) {
        Field currentField = getCurrentField(currentPlayer);
        currentField.setPropertyOwner(currentPlayer);
        currentPlayer.getAccount().addPoint(-currentField.getPrice());
        payrent(currentPlayer);
    }
    public void payrent(Player p ){
        Field f =  getCurrentField(p);
        Player owner = f.getPropertyOwner();


          p.getAccount().addPoint(-f.getPrice());
          owner.getAccount().addPoint(f.getPrice());

    }

    String vinderplayer;

    public boolean gameEnd(PlayerController pc) {

        boolean gameEnd = false;

        for (int i = 0; i < pc.getNumPlayers(); i++) {

            if (pc.getPlayer(i).getAccount().getBalance() >= 30 ){

                vinderplayer=pc.getPlayer(i).getName();
                        gameEnd = true;
            }


        }
        return gameEnd;
    }

    // //gameloop
    public void runGame() {

        GUI_Field[] fields = gui.getFields();

        playerController.setCurrentPlayer(0);

        for (int i = 0; i < playerController.getNumPlayers(); i++) {

            String name = gui.getUserString("Angiv dit navn");

            playerController.getPlayer(i).setName(name);

            GUI_Car car = pieceSelector.pieceselect();

            GUI_Player player = new GUI_Player(name, 20, car);

            playerController.setGUIPlayer(i, player);

            gui.addPlayer(player);

            gui.getFields()[0].setCar(player, true);
        }
        // ! -> ikke
        while (!gameEnd(playerController)) {
            // hvilken spiller vi har fat i
            Player p = playerController.getCurrentPlayer();
            GUI_Player gui_p = playerController.getCurrentGUIPlayer();
            System.out.println("start runde " + p.getName() + " tryk enter");
            //scanner.nextLine();
            gui.getUserButtonPressed("Tryk på knappen", "OK");
            System.out.println(p.getPosition() + " nuværende position ");
            int oldPosition = p.getPosition();

            //bevæger spiller med terningekast.
            int roll = die.roll();
            if (die.getFaceValue() + p.getPosition() >= 23) {
                int newBalance = p.getAccount().getBalance() +2;
                gui_p.setBalance(newBalance);
                p.getAccount().setBalance(newBalance);
            }

            p.movePlayer(roll);
            playerController.switchPlayer();
            gui.setDie(roll);
            int newPosition = p.getPosition();
            fields[oldPosition].setCar(gui_p, false);
            fields[newPosition].setCar(gui_p, true);
            System.out.println(p.getPosition() + " ny position " + "har kastet en " + die.getFaceValue());
            boardController.landedOn(p, board);
            if (canBuyField(p) && checkAccount(p))
            buyField(p);
            else if(!canBuyField(p))
            payrent(p);

            for (int i = 0; i < playerController.getNumPlayers() ; i++) {
                playerController.getGuiPlayerList(i).setBalance(playerController.getPlayer(i).getAccount().getBalance());


            }
        }
        //playerController.switchPlayer();

        Player p = playerController.getCurrentPlayer();
        gui.showMessage("Du har vundet" + " " + vinderplayer);


        playerChoice1();



    }

    public void playerChoice() {
        String value = gui.getUserButtonPressed("Tryk afslut spillet for at slutte spillet," +
                " eller tryk spil for at starte spillet ", "afslut spillet", "Spil spillet");
        if (value == "afslut spillet") {
            System.exit(0);
        }
    }

    public void playerChoice1() {
        String value1 = gui.getUserButtonPressed("Tryk afslut spillet for at slutte spillet, eller tryk spil igen for at" +
                " starte spillet igen ", "afslut spillet", "Spil spillet igen");
        if (value1 == "afslut spillet" ) {
            gui.close();


        }else if ( value1 == "Spil spillet igen"){

                stopGamleSpillet();
        }
    }

    public void stopGamleSpillet(){
        gui.close();
        GameController g1 =new GameController();
        g1.runGame();


    }
}

