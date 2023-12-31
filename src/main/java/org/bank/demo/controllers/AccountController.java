package org.bank.demo.controllers;


import org.bank.demo.api.request.CreateAccountRequest;
import org.bank.demo.api.response.CreateAccountResponse;
import org.bank.demo.entites.Account;
import org.bank.demo.servises.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/admin/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "create")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request){
      return accountService.createAccount(request);
    }

//    @PostMapping(value = "create")
//    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request){
//      return accountService.createAccount((request));
//    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getInfoAccount(@PathVariable("id") Long id){
        Optional<CreateAccountResponse> account = accountService.getInfoAccount(id);
        if (account.isPresent())
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getInfoAccountAll() {
        return new ResponseEntity<>(accountService.getInfoAccountAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
}
