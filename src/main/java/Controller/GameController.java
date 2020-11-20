package Controller;

import Models.Board.Board;
import Models.Board.Die;
import Models.Board.Field;
import Models.Player.Account;
import Models.Player.Player;

import java.util.Scanner;

public class GameController {
    public PlayerController playerController;
    public Board board;
    public Die die;



    public GameController() {
        this.board = new Board();
        this.die = new Die();

    playerController = new PlayerController(4);

    }
    // returnere felt spilleren står på
    public Field getCurrentField(Player currentPlayer){
        return this.board.field[currentPlayer.getPosition()];
    }

    public boolean canBuyField (Player currentPlayer){
        Field currentField = getCurrentField(currentPlayer);
        return currentField.getPropertyOwner() == null;

    }

    //Returne om hvis balance er større end field price
    public boolean checkAccount (Player currentPlayer, Field currentField) {
        return currentPlayer.getAccount().getBalance() >= currentField.getPrice();


    }
    // Sætter currentspiller til FieldOwner og trækker feltets værdi fra spillerens account
    public void  buyField (Player currentPlayer){
        Field currentField = getCurrentField(currentPlayer);
        currentField.setPropertyOwner(currentPlayer);
        currentPlayer.getAccount().addPoint(-currentField.getPrice());

    }

    public boolean gameEnd (PlayerController pc){
       boolean gameEnd = false;
        for (int i = 0; i < pc.getNumPlayers(); i++) {
            if (pc.getPlayer(i).getAccount().getBalance() <= 0)
                gameEnd = true;
        }
        return gameEnd;
    }
    // gameloop
    // ! -> ikke
    public void runGame (){
        Scanner scanner = new Scanner(System.in);
        playerController.setCurrentPlayer(0);
        while (!gameEnd(playerController)){
            System.out.println("start runde");
            scanner.nextLine();
           die.roll();
           int faceValue = die.getFaceValue();
           int currentPosition = playerController.getCurrentPlayer().getPosition();
            System.out.println(currentPosition);
            int newPosition = currentPosition + faceValue;
            playerController.getCurrentPlayer().setPosition(newPosition);



        }
    }

}
