package org.bank.demo.controllers;

import org.bank.demo.api.request.CreateTransactionRequest;
import org.bank.demo.api.response.CreateTransactionResponse;
import org.bank.demo.entites.Transaction;
import org.bank.demo.servises.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/transaction/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "create")
    public CreateTransactionResponse createTransaction(@RequestBody CreateTransactionRequest request) {
        return transactionService.createTransaction(request);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getInfoTransaction(@PathVariable("id") Long id) {
        Optional<Transaction> transaction = transactionService.getInfoTransaction(id);
        if (transaction.isPresent())
            return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
