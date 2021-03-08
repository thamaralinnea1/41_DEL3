package Models.Die;

import Models.Board.Die;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {


    @Test
    public void roll() {

        Die die = new Die();

        int loops = 100;
        int[] faces = new int[6];
        for (int i = 0; i < loops; i++) {
            faces[die.roll() - 1]++;
        }




    }
}