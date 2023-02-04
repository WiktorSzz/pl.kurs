package pl.kurs.exercise3.services;

import pl.kurs.exercise3.models.BankAccount;

import java.util.Date;

public class BankOperations {
    BankAccount accountName;
    private final String operationName;
    private final Date date;
    private final double amount;


    public BankOperations(Date date, String operationName, double amount, BankAccount accountName) {
        this.operationName = operationName;
        this.date = date;
        this.amount = amount;
        this.accountName = accountName;
    }

    public String getOperationName() {
        return operationName;
    }


    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public BankAccount getAccountName() {
        return accountName;
    }

}
