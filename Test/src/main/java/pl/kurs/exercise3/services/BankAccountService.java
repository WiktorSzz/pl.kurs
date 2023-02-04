package pl.kurs.exercise3.services;

import pl.kurs.exercise3.models.BankAccount;

public class BankAccountService {
    BankAccount[] bankOperations;

    public BankAccountService(int capacity) {
        this.bankOperations = new BankAccount[capacity];
    }


}
