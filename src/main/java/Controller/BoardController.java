package Controller;

import Models.Board.Board;
import Models.Board.Field;
import Models.Player.Player;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class BoardController {
    public void landedOn(Player p, Board board){
        int position = p.getPosition();
        Field field =board.getField(position);

        switch (position){
            default:
                System.out.println(field);
        }


    }

    public BoardController (){


        GUI_Field[] fields = new GUI_Field[3];
        fields[0] = new GUI_Start();
        fields[1] = new GUI_Brewery();
        fields[2] = new GUI_Street("street");
        GUI GUIBoard = new GUI(fields);

    }

}
