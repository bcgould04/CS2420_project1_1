package org.advanced.java.programming.project1_1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends BankAccount {
    private double interestRate;
    private double overdraftFee = 30.00;

    public void processWithdrawal(double amount) {
        if (getBalance() <= amount) {
            double newAmount = amount + overdraftFee;
            super.withdrawal(newAmount);
            System.out.println("Balance: " + getBalance() + " An Overdraft Occurred! An additional fee of $" + overdraftFee + " has been charged.");
        } else {
            super.withdrawal(amount);
        }
    }

    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + this.interestRate);
    }
}