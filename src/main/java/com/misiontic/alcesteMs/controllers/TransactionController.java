package com.misiontic.alcesteMs.controllers;

import com.misiontic.alcesteMs.exceptions.InsufficientBalanceException;
import com.misiontic.alcesteMs.models.Transaction;
import com.misiontic.alcesteMs.repositories.TransactionRepository;

import com.misiontic.alcesteMs.models.Account;
import com.misiontic.alcesteMs.repositories.AccountRepository;
import com.misiontic.alcesteMs.exceptions.AccountNotFoundException;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(TransactionRepository transactionRepository, AccountRepository accountRepository){
        this.transactionRepository = transactionRepository;
        this.accountRepository     = accountRepository;
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction transaction){
        Account accountOrigin  = accountRepository.findById(transaction.getEmailOrigin()).orElse(null);
        Account accountDestiny = accountRepository.findById(transaction.getEmailDestiny()).orElse(null);

        if(accountOrigin == null){
            throw new AccountNotFoundException("No se encontró ninguna cuenta asociada al usuario enviado");
        }

        if(accountDestiny == null){
            throw new AccountNotFoundException("No se encontró ninguna cuenta asociada al usuario enviado");
        }

        if(accountOrigin.getBalance() < transaction.getValue()){
            throw new InsufficientBalanceException("La cuenta no tiene saldo suficiente");
        }

        accountOrigin.setBalance(accountOrigin.getBalance() - transaction.getValue());
        accountOrigin.setLastChange(new Date());
        accountRepository.save(accountOrigin);

        accountDestiny.setBalance(accountDestiny.getBalance() + transaction.getValue());
        accountDestiny.setLastChange(new Date());
        accountRepository.save(accountDestiny);

        transaction.setDate( new Date());
        return transactionRepository.save(transaction);
    }

    @GetMapping("/transactions/{email]")
    List<Transaction> userTransaction(@PathVariable String email){
        Account userAccount =
                accountRepository.findById(email).orElse(null);
        if(userAccount == null){
            throw new AccountNotFoundException("El usuario enviado no existe en la base de datos");
        }

        List<Transaction> transactionsOrigin =
                transactionRepository.findByEmailOrigin(email);
        List<Transaction> transactionsDestiny =
                transactionRepository.findByEmailDestiny(email);

        List<Transaction> transactions = Stream.concat(transactionsOrigin.stream(),
                                                        transactionsDestiny.stream())
                                        .collect(Collectors.toList());
        return transactions;
    }
}
