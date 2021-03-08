package Models.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @Test
    public void movePlayer() {

        Player player1 = new Player("Najib", 0,20);
        assertEquals("Najib", player1.getName());
        assertEquals(0, player1.getPosition());
        assertEquals(20, player1.getAccount().getBalance());


        player1.movePlayer(10);
        assertEquals(10, player1.getPosition());

        player1.movePlayer(20);
        assertEquals(6,player1.getPosition());

    }

}

