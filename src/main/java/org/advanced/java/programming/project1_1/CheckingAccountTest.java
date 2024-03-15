package org.advanced.java.programming.project1_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckingAccountTest {
    private CheckingAccount checkingAccount;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setup() {
        checkingAccount = new CheckingAccount();
        System.setOut(new PrintStream(outContent));
        checkingAccount.setFirstName("Test");
        checkingAccount.setLastName("User");
        checkingAccount.setAccountID(12345);
        checkingAccount.deposit(1000.00);
        checkingAccount.setInterestRate(1.5);
    }

    @Test
    public void testDeposit() {
        assertEquals(1000.00, checkingAccount.getBalance());
    }

    @Test
    public void testWithdrawal() {
        checkingAccount.processWithdrawal(300.00);
        assertEquals(700.0, checkingAccount.getBalance());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        checkingAccount.processWithdrawal(1300.00);
        assertEquals(-330, checkingAccount.getBalance());
    }

    @Test
    public void testBalance() {
        assertEquals(1000.00, checkingAccount.getBalance());
    }

    @Test
    public void testDisplayAccount() {

        checkingAccount.displayAccount();
        String expectedOutput =  "First Name: Test" + System.lineSeparator() +
                "Last Name: User" + System.lineSeparator() +
                "Account ID: 12345" + System.lineSeparator() +
                "Balance: 1000.0" + System.lineSeparator() +
                "Interest Rate: 1.5" + System.lineSeparator();

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}