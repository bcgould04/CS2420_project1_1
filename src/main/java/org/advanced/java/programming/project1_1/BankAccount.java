package org.advanced.java.programming.project1_1;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount {

    private String firstName;
    private String lastName;
    private int accountID;


    @Setter(AccessLevel.NONE)
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
            this.balance -= amount;
    }

    public void accountSummary() {
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Account ID: " + this.accountID);
        System.out.println("Balance: " + this.balance);
    }
}
