package Controller;

import Models.Board.Board;
import Models.Board.Field;
import Models.Player.Player;

public class BoardController {
    public void landedOn(Player p, Board board){
        int position = p.getPosition();
        Field field =board.getField(position);

        switch (position){
            default:
                System.out.println(field);
        }

    }
}
