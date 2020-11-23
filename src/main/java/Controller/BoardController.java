package Controller;

import Models.Board.Board;
import Models.Board.Field;
import Models.Player.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

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


        GUI_Field[] fields = new GUI_Field[7];
        fields[0] = new GUI_Start("Start", "Modtag 2M", "", Color.WHITE, Color.BLACK );
        fields[1] = new GUI_Street("Burgerbaren", "1 M","Du er landet på Burgerbaren","1 M", Color.GRAY, Color.BLACK);
        fields[2] = new GUI_Street("Pizzariat", "1 M","Du er landet på Pizzariaet","1 M",Color.GRAY, Color.BLACK);
        fields[3] = new GUI_Chance("Chance","","Tag Chancen!",Color.WHITE,Color.BLACK);
        fields[4] = new GUI_Street("Slikbutik", "1 M","Du er landet på Slikbutikken","1 M",Color.CYAN, Color.BLACK);
        fields[5] = new GUI_Street("Iskiosk", "1 M","Du er landet på Iskiosken","1 M",Color.CYAN, Color.BLACK);
        fields[6] = new GUI_Jail("","Fængsel", "på besøg", "",Color.WHITE, Color.BLACK );
        GUI GUIBoard = new GUI(fields);

        GUIBoard.setDie(1);

    }

}
