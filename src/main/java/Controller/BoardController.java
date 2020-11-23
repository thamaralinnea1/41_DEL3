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


        GUI_Field[] fields = new GUI_Field[15];
        fields[0] = new GUI_Start("Start", "Modtag 2M", "", Color.WHITE, Color.BLACK );
        fields[1] = new GUI_Street("Burgerbaren", "1 M","Du er landet på Burgerbaren","1 M", Color.GRAY, Color.BLACK);
        fields[2] = new GUI_Street("Pizzariat", "1 M","Du er landet på Pizzariaet","1 M",Color.GRAY, Color.BLACK);
        fields[3] = new GUI_Chance("Chance","","Tag Chancen!",Color.WHITE,Color.BLACK);
        fields[4] = new GUI_Street("Slikbutik", "1 M","Du er landet på Slikbutikken","1 M",Color.CYAN, Color.BLACK);
        fields[5] = new GUI_Street("Iskiosk", "1 M","Du er landet på Iskiosken","1 M",Color.CYAN, Color.BLACK);
        fields[6] = new GUI_Jail("","Fængsel", "på besøg", "",Color.WHITE, Color.BLACK );
        fields[7] = new GUI_Street("Museet" , " 2 M ", " Du er landet på Museet " , " 2 M " , Color.MAGENTA , Color.BLACK );
        fields[8] = new GUI_Street("Biblioteket" , " 2 M " , " Welkommen til Biblioteket ", " 2 M " , Color.MAGENTA , Color.BLACK);
        fields[9] = new GUI_Chance("Chance" , "" , " Tag chancen " , Color.WHITE , Color.BLACK );
        fields[10] = new GUI_Street("Skaterparken" , " 2 M " , " Du er kommet til Skaterparken ", " 2 M " , Color.ORANGE , Color.BLACK);
        fields[11] = new GUI_Street("Svømmingpoolen" , " 2 M " , " Plask, du faldt i bassinet " , " 2 M " , Color.ORANGE , Color.BLACK );
        fields[12] = new GUI_Empty(Color.WHITE , Color.BLACK , "Parkering" , "Gratis" , " Du er landet på gratis parkering, tag en pause. ");
        fields[13] = new GUI_Street("Spillehallen" , " 3 M " , " Du er ankommet til spillehallen " , " 3 M " , Color.RED , Color.BLACK);
        fields[14] = new GUI_Street("Biografen" , " 3 M " , " Du er landet på Biografen " , " 3 M " , Color.RED, Color.BLACK);

        GUI GUIBoard = new GUI(fields);


        GUIBoard.setDie(1);

    }

}
