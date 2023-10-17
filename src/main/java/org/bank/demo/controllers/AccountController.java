package org.bank.demo.controllers;


import org.bank.demo.entites.Account;
import org.bank.demo.servise.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "create")
    public Account createAccount(@RequestBody Account account){
      return accountService.createAccount(account);
    }

    @GetMapping(value = "{id}")
    public Account getInfoAccount (@PathVariable("id") Long id){
        return accountService.getInfoAccount(id);
    }
}
