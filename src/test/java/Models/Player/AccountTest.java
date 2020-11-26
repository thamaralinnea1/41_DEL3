package Models.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void Account() {
        Account account = new Account(1000);
        assertEquals(1000, account.balance);
    }

}