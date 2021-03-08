package Models.Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void Account() {

        for (int i = 0; i < 100; i++) {

            Account account = new Account(i*20);

            assertEquals(i*20, account.getBalance());

        }
    }



}