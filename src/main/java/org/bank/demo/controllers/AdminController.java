package org.bank.demo.controllers;

import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.servises.AccountService;
import org.bank.demo.servises.CardService;
import org.bank.demo.servises.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {
    private final AccountService accountService;
    private final CardService cardService;
    private final TransactionService transactionService;

    @Autowired
    public AdminController(AccountService accountService, CardService cardService, TransactionService transactionService) {
        this.accountService = accountService;
        this.cardService = cardService;
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String helloAdminController(){
        return "Admin level access";
    }

/*    @PostMapping("/update")
    public CreateCardResponse updateCardBalance(@RequestBody CreateCardResponse response) {

    }*/

}
