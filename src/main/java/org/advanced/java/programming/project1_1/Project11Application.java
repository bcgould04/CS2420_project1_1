package org.advanced.java.programming.project1_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project11Application {

    public static void main(String[] args) {
        SpringApplication.run(Project11Application.class, args);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setFirstName("John");
        bankAccount.setLastName("Doe");
        bankAccount.setAccountID(123456);
        bankAccount.deposit(2000);
        bankAccount.accountSummary();
        System.out.println("Bank Account Summary for John Doe:");
        bankAccount.accountSummary();

        System.out.println("\nAttempt to withdraw an amount less than the balance:");
        bankAccount.withdrawal(1000);
        bankAccount.accountSummary();

        System.out.println("\nAttempt to withdraw an amount greater than the balance:");
        bankAccount.withdrawal(3000);
        bankAccount.accountSummary();

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setFirstName("Jane");
        checkingAccount.setLastName("Doe");
        checkingAccount.setAccountID(78910);
        checkingAccount.deposit(3000);
        checkingAccount.setInterestRate(1.5);
        checkingAccount.displayAccount();
        System.out.println("\nChecking Account Summary for Jane Doe:");
        checkingAccount.displayAccount();

        System.out.println("\nAttempt to process withdrawal of an amount less than the balance:");
        checkingAccount.processWithdrawal(1000);
        checkingAccount.displayAccount();

        System.out.println("\nAttempt to process withdrawal of an amount greater than the balance:");
        checkingAccount.processWithdrawal(5000);
        checkingAccount.displayAccount();
    }

}
