package Models.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void Account() {
        Account account = new Account(20);
        assertEquals(20, account.balance);
    }


}