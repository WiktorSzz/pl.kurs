package pl.kurs.exercise3.app;

import pl.kurs.exercise3.models.BankAccount;
import pl.kurs.exercise3.services.BankAccountService;


public class BankAccountRunner {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountService(100);
        BankAccount bankAccount = new BankAccount("Konto Przekorzystne", "Pekao", "123456789", 2.3);
        BankAccount bankAccount2 = new BankAccount("Konto Walutowe", "Pekao", "123456789", 2.3);
        BankAccount bankAccount3 = new BankAccount("Konto Profit", "Millenium", "123456789", 3.1);

        bankAccount.depositMoneyIntoBankAccount(bankAccount, 1231);

        bankAccount.depositMoneyIntoBankAccount(bankAccount, 13240);

        bankAccount.withdrawMoneyFromBankAccount(bankAccount2, 1000);

        bankAccount.moneyTransfer(bankAccount, bankAccount2, 1230);

        bankAccount.operationHistory();

        bankAccount.withdrawMoneyFromBankAccount(bankAccount2, 145);

        bankAccount.operationHistory();


    }
}
