package Controller;

import Models.Board.Board;
import Models.Board.Field;
import Models.Player.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class BoardController {

    private GUI GUIBoard;



    public void landedOn(Player p, Board board){
        int position = p.getPosition();
        Field field =board.getField(position);

        switch (position){
            default:
                System.out.println(field);
        }


    }

    public BoardController (){


        GUI_Field[] fields = new GUI_Field[24];
        fields[0] = new GUI_Start("Start", "Modtag 2M", "", Color.WHITE, Color.BLACK );
        fields[1] = new GUI_Street("Burgerbaren", "1 M","Du er landet på Burgerbaren","1 M", Color.GRAY, Color.BLACK);
        fields[2] = new GUI_Street("Pizzariat", "1 M","Du er landet på Pizzariaet","1 M",Color.GRAY, Color.BLACK);
        fields[3] = new GUI_Chance();
        fields[4] = new GUI_Street("Slikbutik", "1 M","Du er landet på Slikbutikken","1 M",Color.CYAN, Color.BLACK);
        fields[5] = new GUI_Street("Iskiosk", "1 M","Du er landet på Iskiosken","1 M",Color.CYAN, Color.BLACK);
        fields[6] = new GUI_Jail();
        fields[6].setSubText(" På besøg ");
        fields[6].setTitle(" Fængsel ");
        fields[6].setDescription(" Du er på besøg i fængslet ");
        fields[7] = new GUI_Street("Museet" , " 2 M ", " Du er landet på Museet " , " 2 M " , Color.MAGENTA , Color.BLACK );
        fields[8] = new GUI_Street("Biblioteket" , " 2 M " , " Welkommen til Biblioteket ", " 2 M " , Color.MAGENTA , Color.BLACK);
        fields[9] = new GUI_Chance();
        fields[10] = new GUI_Street("Skaterparken" , " 2 M " , " Du er kommet til Skaterparken ", " 2 M " , Color.ORANGE , Color.BLACK);
        fields[11] = new GUI_Street("Svømmingpoolen" , " 2 M " , " Plask, du faldt i bassinet " , " 2 M " , Color.ORANGE , Color.BLACK );
        fields[12] = new GUI_Street("Parkering" , "Gratis" , " Du er landet på gratis parkering, tag en pause. " , "" , Color.WHITE , Color.BLACK);
        fields[13] = new GUI_Street("Spillehallen" , " 3 M " , " Du er ankommet til spillehallen " , " 3 M " , Color.RED , Color.BLACK);
        fields[14] = new GUI_Street("Biografen" , " 3 M " , " Du er landet på Biografen " , " 3 M " , Color.RED, Color.BLACK);
        fields[15] = new GUI_Chance();
        fields[16] = new GUI_Street("Legetøjsbutikken", "3 M", "Du landede på Legetøjsbutikken", "3", Color.YELLOW, Color.BLACK);
        fields[17] = new GUI_Street("Dyrehandlen", "3 M", "Du landede på Dyrehandlen", "3", Color.YELLOW, Color.BLACK);
        fields[18] = new GUI_Jail();
        fields[18].setSubText("Gå i Fængsel");
        fields[18].setTitle("Gå i Fængsel");
        fields[18].setDescription("Stop!! Ryk direkte i fængsel");
        fields[19] = new GUI_Street("Bowlinghallen", "4 M", "Du landede på Bowlinghallen", "4", Color.GREEN, Color.BLACK);
        fields[20] = new GUI_Street("Zoologisk Have", "4 M", "Du landede Zoologisk Have", "4", Color.GREEN, Color.BLACK);
        fields[21] = new GUI_Chance();
        fields[22] = new GUI_Street("Vandlandet", "5 M", "Du landede på Vandlandet", "5", Color.BLUE, Color.BLACK);
        fields[23] = new GUI_Street("Strandpromenaden", "5 M", "Du landede på Strandpromenaden", "5", Color.BLUE, Color.BLACK);

        GUIBoard = new GUI(fields);



        GUIBoard.setDie(1);

    }

    public GUI getGUIBoard() {
        return GUIBoard;
    }
}
