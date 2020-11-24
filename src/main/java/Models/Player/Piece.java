package Models.Player;

import gui_main.GUI;

import java.util.Scanner;

public class Piece {

    public GUI gui;
    protected boolean bilLock = false;
    protected boolean racerbilLock = false;
    protected boolean traktorLock = false;
    protected boolean ufoLock = false;


    public void pieceselect() {
        gui.showMessage("Tryk 1 for at være Bilen \nTryk 2 for at være Racerbilen \nTryk 3 for at være Traktoren \nTryk 4 for at være UFO'en");

        while (true) {
            gui.showMessage("Vælg din brik");
            Scanner scan = new Scanner(System.in);
            String characterSelect = scan.nextLine();


            if (characterSelect.equals("1")) {
                if (!bilLock) {
                    this.bilLock = true;
                    gui.showMessage("Du har valgt Bilen");

                    break;
                }
            }
            if (bilLock && characterSelect.equals("1")) {
                gui.showMessage("Bilen er allerede taget");
                continue;
            }

            if (characterSelect.equals("2")) {
                if (!racerbilLock) {
                    this.racerbilLock = true;
                    gui.showMessage("Du har valgt Racerbilen");
                    break;

                }
            }
            if (racerbilLock && characterSelect.equals("2")) {
                gui.showMessage("Racerbilen er allerede taget");

                continue;
            }

            if (characterSelect.equals("3")) {
                if (!traktorLock) {
                    this.traktorLock = true;
                    gui.showMessage("Du har valgt Traktoren");

                    break;
                }
            }
            if (traktorLock && characterSelect.equals("3")) {
                gui.showMessage("Traktoren er allerede taget");
                continue;
            }

            if (characterSelect.equals("4")) {
                if (!ufoLock) {
                    this.ufoLock = true;
                    gui.showMessage("Du har valgt UFO'en");

                    break;
                }
            }
            if (ufoLock && characterSelect.equals("4")) {
                gui.showMessage("UFO'en er allerede taget");
            }
        }
    }



}
