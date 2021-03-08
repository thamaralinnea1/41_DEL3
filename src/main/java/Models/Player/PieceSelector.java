package Models.Player;

import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;

public class PieceSelector {

    public GUI gui;

    protected boolean BilLock = false;
    protected boolean RacerbilLock = false;
    protected boolean TraktorLock = false;
    protected boolean UfoLock = false;

    public PieceSelector(GUI guiBoard){
        this.gui = guiBoard;

    }
    public GUI_Car pieceselect() {

        while (true) {
            String characterSelect = gui.getUserButtonPressed("Vælg bil Tryk 1 for at være bilLock  ELLER Tryk " +
                    "2 for at være Racerbilen ELLER Tryk 3 for at være Traktoren ELLER Tryk 4 " +
                    "for at være UFO'en ", "1", "2", "3", "4");
            if (characterSelect.equals("1")) {
                if (!BilLock) {
                    this.BilLock = true;
                    gui.showMessage("Du har valgt Bilen");
                    GUI_Car car = new GUI_Car(Color.BLACK, Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
                    return car;

                }
            }
            if (BilLock && characterSelect.equals("1")) {
                gui.showMessage("Bilen er allerede taget");
                continue;
            }

            if (characterSelect.equals("2")) {
                if (!RacerbilLock) {
                    this.RacerbilLock = true;
                    gui.showMessage("Du har valgt Racerbilen");
                    GUI_Car racerbilen = new GUI_Car(Color.YELLOW, Color.BLACK, GUI_Car.Type.RACECAR, GUI_Car.Pattern.CHECKERED);

                    return racerbilen;
                }
            }
            if (RacerbilLock && characterSelect.equals("2")) {
                gui.showMessage("Racerbilen er allerede taget");
                continue;
            }
            if (characterSelect.equals("3")) {
                if (!TraktorLock) {
                    this.TraktorLock = true;
                    gui.showMessage("Du har valgt Traktoren");
                    GUI_Car traktoren = new GUI_Car(Color.GREEN, Color.PINK, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.DOTTED);
                    return traktoren;
                }
            }
            if (TraktorLock && characterSelect.equals("3")) {
                gui.showMessage("Traktoren er allerede taget");
                continue;
            }
            if (characterSelect.equals("4")) {
                if (!UfoLock) {
                    this.UfoLock = true;
                    gui.showMessage("Du har valgt UFO'en");
                    GUI_Car ufo = new GUI_Car(Color.WHITE, Color.magenta, GUI_Car.Type.UFO, GUI_Car.Pattern.ZEBRA);
                    return ufo;
                }
            }
            if (UfoLock && characterSelect.equals("4")) {
                gui.showMessage("UFO'en er allerede taget");
            }
        }

    }
}

