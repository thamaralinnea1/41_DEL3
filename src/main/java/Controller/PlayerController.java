package Controller;

import Models.Player.Player;

public class PlayerController {
    public Player currentPlayer;
    public Player[] playerList;
    int currentPlayerId;

    public PlayerController(int amountOfPlayers) {
        this.playerList = new Player[amountOfPlayers];
        this.currentPlayerId = 0;

    }

    //Metode der flytter spiller
    public void movePlayer (int positon ){
        this.currentPlayer.setPosition(positon);

    }

    //CurrentPlayer øges med 1. Modules bruges så curretn player ikke kan overskride arraylist.
    public void switchPlayer(){
        currentPlayerId = (currentPlayerId+1)%playerList.length;
        currentPlayer = playerList[currentPlayerId];

    }


}
