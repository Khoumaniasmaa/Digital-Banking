package org.sid.ebankingbackend.services;

import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.sid.ebankingbackend.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BankService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount =
                bankAccountRepository.findById("3be7ed1f-f8bc-444d-9540-0f5158ea2465").orElse(null);
        if (bankAccount != null) {
            System.out.println("**************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft=>" + ((CurrentAccount) bankAccount).getOverDraft());

            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println(op.getType() + "\t" +
                        (op.getOperationDate()) + "\t" +
                        (op.getAmount()));
            });
    }
}}
