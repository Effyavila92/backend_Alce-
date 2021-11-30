package com.misiontic.alcesteMs.controllers;

import com.misiontic.alcesteMs.exceptions.AccountNotFoundException;
import com.misiontic.alcesteMs.models.Account;
import com.misiontic.alcesteMs.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
     private final AccountRepository accountRepository;

     public AccountController(AccountRepository accountRepository){
         this.accountRepository = accountRepository;
     }

     @GetMapping("/accounts/{email}")
     Account getAccount(@PathVariable String email){
         return accountRepository.findById(email)
                 .orElseThrow(() -> new AccountNotFoundException("No se encontro ninguna cuenta asociada al usuario enviado"
                 ));
     }

     @PostMapping("/accounts")
    Account newAccount(@RequestBody Account account){
        return accountRepository.save(account);
     }
}
