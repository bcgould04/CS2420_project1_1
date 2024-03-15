package org.advanced.java.programming.project1_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountTest {
    private BankAccount bankAccount;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount();
        System.setOut(new PrintStream(outContent));
        bankAccount.setFirstName("Test");
        bankAccount.setLastName("User");
        bankAccount.setAccountID(12345);
        bankAccount.deposit(1000);
    }

    @Test
    public void testDeposit() {
        assertEquals(1000.00, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawal() {
        bankAccount.withdrawal(100.0);
        assertEquals(900.00, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawalFromZeroBalance() {
        bankAccount.withdrawal(1100.0);
        assertEquals(-100.0, bankAccount.getBalance(), () -> "Withdrawal from zero balance should result in negative balance");
    }

    @Test
    public void testAccountSummary() {
        bankAccount.accountSummary();

        String expectedOutput = "First Name: Test" + System.lineSeparator() +
                "Last Name: User" + System.lineSeparator() +
                "Account ID: 12345" + System.lineSeparator() +
                "Balance: 1000.0" + System.lineSeparator();

        assertTrue(outContent.toString().contains(expectedOutput));
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
