package Controller;

import Models.Player.Player;
import gui_fields.GUI_Player;

public class PlayerController {
    private Player currentPlayer;
    private Player[] playerList;
    private GUI_Player[] guiPlayerList;
    private int currentPlayerId;
    private GUI_Player[] gui_players;

    public PlayerController(int amountOfPlayers) {
        this.playerList = new Player[amountOfPlayers];
        this.guiPlayerList = new GUI_Player[amountOfPlayers];
        this.currentPlayerId = 0;

        // opretter spillere og ligger dem i spillerliste
        for (int i = 0; i < amountOfPlayers; i++) {
            Player player = new Player("player " + i,0,2);
            playerList[i] = player;
        }

    }

    public Player getPlayer (int playerIndex){
        return playerList[playerIndex];
    }

    //Metode der flytter spiller
    public void movePlayer (int positon){
        this.currentPlayer.setPosition(positon);

    }

    public GUI_Player getCurrentGUIPlayer(){
        return guiPlayerList[currentPlayerId];
    }

    public void setGUIPlayer(int playerIndex, GUI_Player gui_player){
        guiPlayerList[playerIndex] = gui_player;
    }


    //CurrentPlayer øges med 1. Modulus bruges så current player ikke kan overskride arraylist.
    public Player switchPlayer(){

        currentPlayerId = (currentPlayerId+1)%playerList.length;
        currentPlayer = playerList[currentPlayerId];
        return playerList[currentPlayerId];

    }
    public void setCurrentPlayer(int index){
        currentPlayerId = index;
        currentPlayer = playerList[index];
    }

    public Player getCurrentPlayer (){
        return currentPlayer;
    }

    public int getNumPlayers(){
        return playerList.length;
    }

}
