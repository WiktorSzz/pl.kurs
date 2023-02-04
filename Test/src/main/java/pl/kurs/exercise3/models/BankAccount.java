package pl.kurs.exercise3.models;

import pl.kurs.exercise3.services.BankOperations;

import java.util.Date;

public class BankAccount {
    private String bankAccountName;
    private String bankName;
    private String ownerPesel;
    private double interestRate;
    private double bankAccountBalance;
    BankOperations[] bankOperations;
    private int howManyOperations;


    public BankAccount(String bankAccountName, String bankName, String ownerPesel, double interestRate) {
        this.bankAccountName = bankAccountName;
        this.bankName = bankName;
        this.ownerPesel = ownerPesel;
        this.interestRate = interestRate;
    }


    public String getBankAccountName() {
        return bankAccountName;
    }

    public double getBankAccountBalance() {
        return bankAccountBalance;
    }

    public void setBankAccountBalance(double bankAccountBalance) {
        this.bankAccountBalance = bankAccountBalance;
    }

    @Override
    public String toString() {
        return '\'' + bankAccountName + '\'';
    }


    public void depositMoneyIntoBankAccount(BankAccount bankAccount, double amount) {
        if (bankAccount != null) {
            if (amount > 0) {
                bankAccount.setBankAccountBalance(bankAccount.getBankAccountBalance() + amount);
                System.out.println("Wpłacono na konto: " + String.format("%.2f", amount) + ", stan konta po operacji: " + String.format("%.2f", bankAccount.getBankAccountBalance()));
                addBankOperation(new BankOperations(new Date(), "Wpłata", amount, bankAccount));
            }

        }
    }

    public void withdrawMoneyFromBankAccount(BankAccount bankAccount, double amount) {
        if (bankAccount != null) {
            if (bankAccount.getBankAccountBalance() < amount) {
                System.out.println("Nie masz wystarczających środków do wykonania operacji.");
            } else {
                bankAccount.setBankAccountBalance(bankAccount.getBankAccountBalance() - amount);
                System.out.println("Wypłacono: " + String.format("%.2f", amount) + ". Stan konta po operacji: " + String.format("%.2f", bankAccount.getBankAccountBalance()));
                addBankOperation(new BankOperations(new Date(), "Wypłata", amount, bankAccount));
            }
        }
    }

    public void moneyTransfer(BankAccount bankAccount, BankAccount bankAccount2, double amount) {
        if (bankAccount != null && bankAccount2 != null) {
            if (bankAccount.getBankAccountBalance() < amount) {
                System.out.println("Nie masz wystarczających środków do wykonania operacji.");
            } else {
                bankAccount.setBankAccountBalance(bankAccount.getBankAccountBalance() - amount);
                bankAccount2.setBankAccountBalance(bankAccount2.getBankAccountBalance() + amount);
                System.out.println("Stan konta: " + bankAccount.getBankAccountName() + " po operacji: " + String.format("%.2f", bankAccount.getBankAccountBalance()) + ", stan konta: " + bankAccount2.getBankAccountName() + " po operacji: " + String.format("%.2f", bankAccount2.getBankAccountBalance()));
                addBankOperation(new BankOperations(new Date(), "Przelew", amount, bankAccount));
            }
        }
    }

    private void addBankOperation(BankOperations bankOperation) {
        if (bankOperations == null) {
            bankOperations = new BankOperations[1];
        } else if (howManyOperations == bankOperations.length) {
            BankOperations[] bankOperations1 = new BankOperations[bankOperations.length * 2];
            System.arraycopy(bankOperations, 0, bankOperations1, 0, bankOperations.length);
            bankOperations = bankOperations1;
        }
        bankOperations[howManyOperations++] = bankOperation;
    }

    public void operationHistory() {
        for (int i = 0; i < howManyOperations; i++) {
            BankOperations bankOperation = bankOperations[i];
            System.out.println((i + 1) + ". Dnia " + bankOperation.getDate() + " wykonano operację " + bankOperation.getOperationName() + " na kwotę " + String.format("%.2f", bankOperation.getAmount()) + " ,konto operacyjne: " + bankOperation.getAccountName());
        }
    }
}








