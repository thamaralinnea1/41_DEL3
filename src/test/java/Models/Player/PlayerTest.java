package Models.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void currentPlayer() {
        Player player = new Player("Najib",0,20);
        assertEquals("Najib", player.getName());
        assertEquals(0, player.getPosition());
        assertEquals(20, player.getAccount().getBalance());

    }

}