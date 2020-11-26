package Models.Board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {


    @Test
    public void roll() {
        int normalmargin = 400;
        int loops = 100;
        Die die = new Die();
        int[] faces = new int[6];
        for (int i = 0; i < loops; i++) {
            faces[die.roll() - 1]++;
        }




    }
}