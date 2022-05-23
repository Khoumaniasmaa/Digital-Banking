package org.sid.ebankingbackend.services;

import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.sid.ebankingbackend.exceptions.BanlanceNotSufficientException;
import org.sid.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount (double initialBalance , double overDraft, long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount (double initialBalance , double interestRate, long customerId) throws CustomerNotFoundException;
    List<Customer>listCustomer();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void  debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BanlanceNotSufficientException;
    void credit(String accountId , double amount, String description) throws BankAccountNotFoundException;
    void transfer(String  accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BanlanceNotSufficientException;

    List<BankAccount> bankAccountList();
}
