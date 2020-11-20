package Controller;

import Models.Board.Board;
import Models.Board.Die;
import Models.Board.Field;
import Models.Player.Account;
import Models.Player.Player;

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

    //Returne om hvis balance er støre end field price
    public boolean checkAccount (Player currentPlayer, Field currentField) {
        return currentPlayer.getAccount().getBalance() >= currentField.getPrice();


    }

    public void  buyField (Player currentPlayer){
        Field currentField = getCurrentField(currentPlayer);
        currentField.setPropertyOwner(currentPlayer);
        currentPlayer.getAccount().addPoint(-currentField.getPrice());

    }


}
