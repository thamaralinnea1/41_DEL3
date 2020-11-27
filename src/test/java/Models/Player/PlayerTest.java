package Models.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void Player() {
        Player player = new Player("Najib",0,20);
        assertEquals("Najib", player.getName());
        assertEquals(0, player.getPosition());
        assertEquals(20, player.getAccount().getBalance());
        assertEquals(0, player.getPosition());
        assertEquals(0, player.getPosition());

    }

//    @Test
//    public void movePlayer() {
//        Player player1 = new Player("Najib", 0,20);
//        player1.movePlayer(10);
//        assertEquals(10, player1.getPosition());
//        assertEquals(10,0);
//        assertFalse();
//        player1.movePlayer(20);
//        assertEquals(6, player1.setPosition(););
//        assertEquals(10, player1.previousFelt);
//        assertTrue(player1.passedStart);
//    }

}

