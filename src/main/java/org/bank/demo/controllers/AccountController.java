package org.bank.demo.controllers;


import org.bank.demo.entites.Account;
import org.bank.demo.servises.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/account/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    public ResponseEntity<Account> createAccount(@RequestBody Account account){
      Account account1 = accountService.createAccount(account);
      return new ResponseEntity<>(account1, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public Optional<Account> getInfoAccount (@PathVariable("id") Long id){
        return accountService.getInfoAccount(id);
    }
}
